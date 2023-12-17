package Representation;

import Tools.BackgroundPanel;

import java.awt.*;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import Univers.Personnage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Scenario extends JFrame{
    public Event initialNode;
    private JPanel pnlRoot;
    public static Image imagePlayer;
    private Sauvegarde sauvegarde;
    JFrame jFrame = this;
    JLabel checkpointLabel;
    Personnage personnage;
    public Scenario() throws IOException, ParseException {
        this.initialNode = null;
        personnage = new Personnage();
        Class<?> classePersonnage;
        this.loadScenarioFromJson("src/data.json");
    }

    public void loadScenarioFromJson(String jsonFilePath) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject root = (JSONObject) parser.parse(new FileReader(jsonFilePath));
            this.initialNode = (Event) createNodeFromJson(root);
        } catch (IOException | ParseException e) {
            System.out.println("--ERREUR--");
            e.printStackTrace();
        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }
    private Event createNodeFromJson(JSONObject jsonData) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String nodeType = (String) jsonData.get("type");
        String description = (String) jsonData.get("description");
        JSONObject pathFile = (JSONObject) jsonData.get("pathfile");

        Event innerNode;
        if (nodeType.equals("DecisionNode") || nodeType.equals("ChanceNode") || nodeType.equals("CombatNode") ) {
            if (nodeType.equals("DecisionNode")) {
                innerNode = new DecisionNode(description);
            } else if (nodeType.equals("ChanceNode")){
                innerNode = new ChanceNode(description);
            } else {
                innerNode = new CombatNode(description);
            }
            innerNode = getEvent(pathFile, innerNode);
            try{
                JSONArray choicesData = (JSONArray) jsonData.get("choices");
                if(choicesData == null) throw new Exception("Vous n'avez pas de nodes successeurs pour ce node : " + innerNode);
                for (Object choiceObject : choicesData) {
                    JSONObject choiceData = (JSONObject) choiceObject;
                    innerNode.addNode(createNodeFromJson(choiceData));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            return innerNode;
        } else if (nodeType.equals("TerminalNode")) {
            Event terminalNode = new TerminalNode(description);
            terminalNode = getEvent(pathFile, terminalNode);
            return terminalNode;
        }
        return null;
    }

    private Event getEvent(JSONObject pathFile, Event node) throws LineUnavailableException, IOException {
        if(pathFile != null){
            if(pathFile.containsKey("Image")){
                node = new ImageNode((Node) node, (String) pathFile.get("Image"));
            }
            else if (pathFile.containsKey("Sound")){
                node = new SoundNode((Node) node,(String) pathFile.get("Sound"));
            }
        }
        return node;
    }

    @Override
    public String toString() {
        return this.toString((Node) initialNode);
    }

    private String toString(Node currentNode) {
        StringBuilder result = new StringBuilder(currentNode.toString());
        if (currentNode instanceof InnerNode) {
            for (Event node : currentNode.getNextNodes()) {
                result.append(this.toString((Node) node));
            }
        }
        return result.toString();
    }

    /*Nouvelle version*/

    /**
     * @param initialNode
     */
    public void playScenario(Event initialNode) throws ClassNotFoundException, IOException, InterruptedException {
        this.sauvegarde = new Sauvegarde();
        personnage = this.sauvegarde.getPersonnage();
        Event currentNode = initialNode;
        boolean iterate = true;
        ArrayList<Event> checkpoints = new ArrayList<>();
        ArrayList<ArrayList<Event>> partie = new ArrayList<>();
        checkpointLabel = new JLabel("Vous avez atteint un nouveau checkpoint !");
        checkpointLabel.setFont(new Font("Arial",Font.PLAIN,30));
        while (iterate && currentNode!=null) {
            checkpoints.add(currentNode);
            if(currentNode.getId() == 0){
                JPanel nestedPanel = (JPanel) pnlRoot.getComponent(1);
                JButton button = (JButton) nestedPanel.getComponent(0);
                JButton button1 = (JButton) nestedPanel.getComponent(2);
                Sauvegarde savedPartie = JFrameFunctionnalities.waitForSelection(new JButton[]{button, button1}, nestedPanel);
                if(savedPartie != null){
                    currentNode = savedPartie.getPartie().get(savedPartie.getPartie().size() -1).get(2);
                    personnage = savedPartie.getPersonnage();
                    currentNode.display(this.pnlRoot);
                }
            }
            else{
                currentNode.display(this.pnlRoot);
            }
            if(currentNode instanceof TerminalNode){
                iterate = false;
            }
            if(currentNode instanceof CombatNode){
                currentNode = currentNode.chooseNext(pnlRoot,personnage);
            }
            currentNode = currentNode.chooseNext(pnlRoot, personnage);
            if(!(personnage.isDemon() | personnage.isEmpereur())) {
                personnage.setEspeceFromString(currentNode.toString());
                if(personnage.isDemon()){
                    personnage.setImageFilePersonnage("../Images/Skeleton_Walk.gif");
                }
            }
            if(checkpoints.size() % 3 == 0) {
                personnage.evoluerGrade();
                partie.add(checkpoints);
                checkpoints = new ArrayList<>();
                pnlRoot.add(checkpointLabel,BorderLayout.SOUTH);
                pnlRoot.revalidate();
                pnlRoot.repaint();
                System.out.println("Nouveau checkpoint !");
                checkpointLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
                sauvegarde.setPersonnage(personnage);
            }

            System.out.println("Evolution " + personnage);

        }
        sauvegarde.setPartie(partie);
        System.out.println(sauvegarde);
        if(!partie.isEmpty()){
            if(JOptionPane.showConfirmDialog(pnlRoot,"Voulez vous sauvegardez votre partie ? (checkpoint n°"+ partie.size()  +"/4)","SAUVEGARDE",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                sauvegarde.savePartie();
                System.out.println(Sauvegarde.reprendrePartie());
            }
        }
        // Le jeu est terminé
        System.out.println("Fin du jeu");
    }


    private void createUIComponents() throws IOException {
        Random random = new Random();
        this.pnlRoot = new BackgroundPanel("src/Background/background"+ random.nextInt(1,5) + ".png");
        this.setContentPane(pnlRoot);
        this.pnlRoot.setLayout(new BorderLayout()); // Use FlowLayout for simplicity

        JLabel lbl = new JLabel("Kingdom War");
        lbl.setFont(new Font("Arial",Font.PLAIN,30));
        lbl.setHorizontalAlignment(0);
        pnlRoot.add(lbl,BorderLayout.NORTH);
        this.setResizable(false);

        JPanel jpanelMenu = new JPanel(new GridBagLayout());
        jpanelMenu.setPreferredSize(new Dimension(200, 100));
        JButton btnStart = new JButton("Commencer la partie");
        JButton btnSave = new JButton("Reprendre depuis une sauvegarde");


        Sauvegarde sauvegarde1 = new Sauvegarde();

        System.out.println(sauvegarde1);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridy = 2;

        jpanelMenu.add(btnStart, gbc);

        gbc.gridy = 3;
        jpanelMenu.add(Box.createRigidArea(new Dimension(0, 10)), gbc); // Add vertical gap

        gbc.gridy = 5;
        jpanelMenu.add(btnSave, gbc);

        // Center the panel
        jpanelMenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpanelMenu.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Make the panel transparent
        jpanelMenu.setOpaque(false);
        jpanelMenu.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        pnlRoot.add(jpanelMenu);
        this.pack();
        this.setTitle("Kingdom War");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

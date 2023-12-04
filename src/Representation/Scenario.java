package Representation;

import Tools.BackgroundPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

import Univers.Espece;
import Univers.EvoluerPersonnage;
import Univers.Personnage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import static Univers.EvoluerPersonnage.EvoluerPersonnage;

public class Scenario extends JFrame{
    public Event initialNode;
    private JPanel pnlRoot;
    public static Image imagePlayer;
    private Sauvegarde sauvegarde;
    JFrame jFrame = this;
    JLabel checkpointLabel;

    public Scenario() throws IOException, ParseException {
        this.initialNode = null;
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
    public void playScenario(Event initialNode) throws ClassNotFoundException, IOException {
        this.sauvegarde = new Sauvegarde();
        Personnage personnage = new Personnage();
        Class<?> classePersonnage;
        Event currentNode = initialNode;
        boolean iterate = true;
        ArrayList<Event> checkpoints = new ArrayList<>();
        ArrayList<ArrayList<Event>> partie = new ArrayList<>();
        checkpointLabel = new JLabel("Vous avez atteint un nouveau checkpoint !");
        checkpointLabel.setFont(new Font("Arial",Font.PLAIN,30));
        while (iterate && currentNode!=null) {
            checkpoints.add(currentNode);
            currentNode.display(this.pnlRoot);
            if(currentNode instanceof TerminalNode){
                iterate = false;
            }
            currentNode = currentNode.chooseNext(pnlRoot);
            if(!(personnage.isDemon() | personnage.isEmpereur())) {
                personnage.setEspeceFromString(currentNode.toString());
            }
            if(checkpoints.size() % 4 == 0) {
                personnage.evoluerGrade();
                partie.add(checkpoints);
                checkpoints = new ArrayList<>();
                pnlRoot.add(checkpointLabel,BorderLayout.SOUTH);
                checkpointLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
            }

            System.out.println("Evolution " + personnage);

        }
        sauvegarde.setPartie(partie);
        System.out.println(sauvegarde);
//        if(!partie.isEmpty()){
//            JOptionPane.showMessageDialog(pnlRoot,"Voulez vous sauvegardez votre partie ? (checkpoint n°"+ partie.size()  +"/4)","SAUVEGARDE",JOptionPane.INFORMATION_MESSAGE);
//        }
        sauvegarde.savePartie();
        System.out.println(Sauvegarde.reprendrePartie());
        // Le jeu est terminé
        System.out.println("Fin du jeu");
    }


    private void createUIComponents() throws IOException, ClassNotFoundException {
        this.pnlRoot = new BackgroundPanel("src/Background/background1.png");
        this.setContentPane(pnlRoot);
        this.pnlRoot.setLayout(new BorderLayout()); // Use FlowLayout for simplicity

        JLabel lbl = new JLabel("Kingdom War");
        lbl.setFont(new Font("Arial",Font.PLAIN,30));
        lbl.setHorizontalAlignment(0);
        pnlRoot.add(lbl,BorderLayout.NORTH);

        JPanel jpanelMenu = new JPanel(new GridBagLayout());
        jpanelMenu.setPreferredSize(new Dimension(200, 100));
        JButton btnStart = new JButton("Commencer la partie");
        JButton btnSave = new JButton("Reprendre depuis une sauvegarde");

//        btnSave.addActionListener(e -> {
//            try {
//                System.out.println(sauvegarde.reprendrePartie());
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            } catch (ClassNotFoundException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
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

        // Set a colored border with a specific color
//        jpanelMenu.setBorder(new LineBorder(Color.RED, 2));
        pnlRoot.add(jpanelMenu);
        this.pack();
        this.setTitle("Kingdom War");
        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

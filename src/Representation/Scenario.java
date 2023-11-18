package Representation;

import Tools.BackgroundPanel;

import java.awt.*;
import java.io.IOException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class Scenario extends JFrame{
    public Node initialNode;
    private JPanel pnlRoot;

    public Scenario() throws IOException, ParseException {
        this.initialNode = null;
        this.loadScenarioFromJson("src/data.json");
    }

    public void loadScenarioFromJson(String jsonFilePath) {
        JSONParser parser = new JSONParser();

        try {
            JSONObject root = (JSONObject) parser.parse(new FileReader(jsonFilePath));
            this.initialNode = (Node) createNodeFromJson(root);
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
        if (nodeType.equals("DecisionNode") || nodeType.equals("ChanceNode")) {
            if (nodeType.equals("DecisionNode")) {
                innerNode = new DecisionNode(description);
            } else {
                innerNode = new ChanceNode(description);
            }
            innerNode = getEvent(pathFile, innerNode);
            try{
                JSONArray choicesData = (JSONArray) jsonData.get("choices");
                if(choicesData == null) throw new Exception("Vous n'avez pas de nodes successeurs pour ce node");
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

    private Event getEvent(JSONObject pathFile, Event node) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
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
        return this.toString(initialNode);
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
    public void playScenario(Event initialNode) {
        Event currentNode = initialNode;

        while (!(currentNode instanceof TerminalNode)) {
            // Laisser le joueur choisir le prochain nœud
            currentNode.display(this.pnlRoot);
            currentNode = currentNode.chooseNext();
        }

        // Le jeu est terminé
        System.out.println("Fin du jeu");
    }

    private void createUIComponents() {
        this.pnlRoot = new BackgroundPanel("src/Background/background1.png");
        this.setContentPane(pnlRoot);
        this.pnlRoot.setLayout(new FlowLayout()); // Use FlowLayout for simplicity

        JLabel lbl = new JLabel("Kingdom War");
        lbl.setFont(new Font("Arial",Font.PLAIN,30));

        this.setTitle("Kingdom War");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

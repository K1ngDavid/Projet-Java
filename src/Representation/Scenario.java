package Representation;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Scenario {
    public Node initialNode;


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
        }
    }
    private Event createNodeFromJson(JSONObject jsonData) {
        String nodeType = (String) jsonData.get("type");
        String description = (String) jsonData.get("description");
        String pathFile = (String) jsonData.get("pathfile");

        Event innerNode;
        if (nodeType.equals("DecisionNode") || nodeType.equals("ChanceNode")) {
            if (nodeType.equals("DecisionNode")) {
                innerNode = new DecisionNode(description);
            } else {
                innerNode = new ChanceNode(description);
            }
            if(pathFile != null && ImageNode.isImageFile(pathFile)){

                innerNode = new ImageNode((Node) innerNode,pathFile);
            }
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
            return new TerminalNode(description);
        }
        return null;
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


    public void playScenario(Node initialNode) {
        Node currentNode = initialNode;

        while (!(currentNode instanceof TerminalNode)) {
            // Laisser le joueur choisir le prochain nœud
            currentNode.display();
            System.out.println(currentNode.getNextNodes());
            currentNode = (Node) currentNode.chooseNext();
        }

        // Le jeu est terminé
        System.out.println("Fin du jeu");
    }
}

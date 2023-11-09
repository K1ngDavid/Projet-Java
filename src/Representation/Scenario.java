package Representation;

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
            this.initialNode = createNodeFromJson(root);
        } catch (IOException | ParseException e) {
            System.out.println("--ERREUR--");
            e.printStackTrace();
        }
    }
    private Node createNodeFromJson(JSONObject jsonData) {
        String nodeType = (String) jsonData.get("type");
        String description = (String) jsonData.get("description");
        InnerNode innerNode;

        if (nodeType.equals("DecisionNode") || nodeType.equals("ChanceNode")) {
            if (nodeType.equals("DecisionNode")) {
                innerNode = new DecisionNode(description);
            } else {
                innerNode = new ChanceNode(description);
            }
            JSONArray choicesData = (JSONArray) jsonData.get("choices");

            for (Object choiceObject : choicesData) {
                JSONObject choiceData = (JSONObject) choiceObject;
                innerNode.addNode(createNodeFromJson(choiceData));
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
            for (Node node : currentNode.getNextNodes()) {
                result.append(this.toString(node));
            }
        }
        return result.toString();
    }


    public void playScenario(Node initialNode) {
        Node currentNode = initialNode;

        while (!(currentNode instanceof TerminalNode)) {
            // Laisser le joueur choisir le prochain nœud
            currentNode = currentNode.chooseNext();
        }

        // Le jeu est terminé
        System.out.println("Fin du jeu");
    }
}

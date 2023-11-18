package Representation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecisionNode extends InnerNode{
    List<Event> nextNodes;
    private static final Scanner myScanner = new Scanner(System.in);
    public DecisionNode(String description,List<Event> nextNodes) {
        super(description);
        this.nextNodes = nextNodes;
    }

    public DecisionNode(String description){
        super(description);
        this.nextNodes = new ArrayList<>();
    }
    @Override
    public void addNode(Event node){
        nextNodes.add(node);
    }

    /*ANCIENNE VERSION
    @Override
    public Event chooseNext() {
        int index = 0;
        for (Event node : this.nextNodes){
            index++;
            System.out.println(index + " : " + ((Node) node).getDescription());
        }
        int choice = -1; // Initialisation à une valeur invalide pour entrer dans la boucle

        while (choice < 1 || choice >= nextNodes.size() + 1) {
            System.out.println("Quel est votre choix ?");
            try {
                choice = Integer.parseInt(myScanner.nextLine());

                if (choice < 1 || choice >= nextNodes.size() + 1) {
                    System.out.println("Choix invalide. Veuillez sélectionner un choix valide.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro de choix valide.");
            }
        }

        System.out.println("Vous avez choisi le choix numéro " + choice);
        return nextNodes.get(choice -1);
    }
    */

    @Override
    public void display(JPanel pnlRoot) {
        super.display(pnlRoot);
    }

    @Override
    public Event chooseNext() {
        int index = 0;
        for (Event node : this.nextNodes){
            index++;
            System.out.println(index + " : " + node);
        }
        int choice = -1; // Initialisation à une valeur invalide pour entrer dans la boucle

        while (choice < 1 || choice >= nextNodes.size() + 1) {
            System.out.println("Quel est votre choix ?");
            try {
                choice = Integer.parseInt(myScanner.nextLine());

                if (choice < 1 || choice >= nextNodes.size() + 1) {
                    System.out.println("Choix invalide. Veuillez sélectionner un choix valide.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un numéro de choix valide.");
            }
        }

        System.out.println("Vous avez choisi le choix numéro " + choice);
        return nextNodes.get(choice -1);
    }



    @Override
    public List<Event> getNextNodes() {
        return nextNodes;
    }
}

package Representation;

import Tools.BugReport;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecisionNode extends InnerNode{
    List<Event> nextNodes;
    private Event selectedNode;

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


    @BugReport(
            reportedBy = {"David"},
            description = "Bug sur la méthode chooseNext qui renvoie un node Null",
            priority = BugReport.PRIORITY.HIGH,
            status = BugReport.STATUS.FIXED
    )
    @Override
    public Event chooseNext(JPanel pnlRoot) {
        pnlRoot.removeAll();

        for (int i = 0; i < nextNodes.size(); i++) {
            Event node = nextNodes.get(i);

            JButton choiceButton = new JButton((i + 1) + ": " + node);
            choiceButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pnlRoot.removeAll(); // Supprimer tous les composants précédents
                    pnlRoot.revalidate();
                    pnlRoot.repaint();
                    // il fallait supprimer la méthode display() que j'avais mis içi
                    // Appeler setSelectedNode pour définir le nœud sélectionné
                    setSelectedNode(node);
                }
            });

            pnlRoot.add(choiceButton);
        }

        pnlRoot.revalidate();
        pnlRoot.repaint();

        // Attente de la sélection de l'utilisateur
        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Retourner le nœud sélectionné
        return selectedNode;
    }

    // Cette méthode sera appelée par l'actionListener pour définir le nœud sélectionné
    private void setSelectedNode(Event selectedNode) {
        this.selectedNode = selectedNode;

        // Réveiller le thread bloqué dans wait()
        synchronized (lock) {
            lock.notify();
        }
    }


//    @Override
//    public Event chooseNext() {
//        int index = 0;
//        for (Event node : this.nextNodes){
//            index++;
//            System.out.println(index + " : " + node);
//        }
//        int choice = -1; // Initialisation à une valeur invalide pour entrer dans la boucle
//
//        while (choice < 1 || choice >= nextNodes.size() + 1) {
//            System.out.println("Quel est votre choix ?");
//            try {
//                choice = Integer.parseInt(myScanner.nextLine());
//
//                if (choice < 1 || choice >= nextNodes.size() + 1) {
//                    System.out.println("Choix invalide. Veuillez sélectionner un choix valide.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Veuillez entrer un numéro de choix valide.");
//            }
//        }
//        System.out.println("Vous avez choisi le choix numéro " + choice);
//        return nextNodes.get(choice -1);
//    }



    @Override
    public List<Event> getNextNodes() {
        return nextNodes;
    }
}

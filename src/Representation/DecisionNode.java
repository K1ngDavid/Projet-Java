package Representation;

import Tools.BackgroundPanel;
import Tools.BugReport;
import Univers.Personnage;

import javax.swing.*;
import java.awt.*;
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


    @Override
    public void display(JPanel pnlRoot) {
        super.display(pnlRoot);
    }


    /**
     * @param pnlRoot    which is the Jpanel of the window
     * @param personnage
     * @return a node which is an Event type
     */
    @BugReport(
            reportedBy = {"David"},
            description = "Bug sur la méthode chooseNext qui renvoie un node Null",
            priority = BugReport.PRIORITY.HIGH,
            status = BugReport.STATUS.FIXED
    )
    @Override
    public Event chooseNext(JPanel pnlRoot, Personnage personnage) {
        pnlRoot.removeAll();
        JPanel buttonPanel = new BackgroundPanel("src/Background/background1.png");
        buttonPanel.setLayout(new GridBagLayout());
        pnlRoot.add(buttonPanel, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Marge entre les boutons

        for (int i = 0; i < nextNodes.size(); i++) {
            Event node = nextNodes.get(i);

            JButton choiceButton = new JButton((i + 1) + ": " + node);
            choiceButton.addActionListener(e -> {
                // Ne retirez pas les composants directement du panneau racine (pnlRoot),
                // retirez-les du panneau de boutons (buttonPanel) à la place.
                buttonPanel.removeAll();
                pnlRoot.revalidate();
                pnlRoot.repaint();
                setSelectedNode(node);
            });

            gbc.gridy = i; // Change the row for each button
            buttonPanel.add(choiceButton, gbc);
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

    @Override
    public List<Event> getNextNodes() {
        return nextNodes;
    }
}

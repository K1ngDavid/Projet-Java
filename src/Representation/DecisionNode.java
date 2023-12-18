package Representation;

import Tools.BackgroundPanel;
import Tools.BugReport;
import Univers.Personnage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe DecisionNode, classe fille la classe InnerNode, elle est abstraite car on ne l'utilise pas directement, on utilise ses enfants
 * La classe implémente Event et Serialisable
 * @author David Roufé
 */
public class DecisionNode extends InnerNode{
    List<Event> nextNodes;
    private Event selectedNode;
    private JPanel buttonPanel;

    /**
     * Constructeur de la classe DecisionNode avec une description et une liste de noeuds suivants.
     *
     * @param description La description du noeud de décision.
     * @param nextNodes   La liste des noeuds suivants possibles.
     */
    public DecisionNode(String description,List<Event> nextNodes) {
        super(description);
        this.nextNodes = nextNodes;
    }

    /**
     * Constructeur de la classe DecisionNode avec une description. Initialise la liste des noeuds suivants à une liste vide.
     *
     * @param description La description du noeud de décision.
     */
    public DecisionNode(String description){
        super(description);
        this.nextNodes = new ArrayList<>();
    }
    /**
     * Ajoute un noeud à la liste des noeuds suivants.
     *
     * @param node Le noeud à ajouter.
     */
    @Override
    public void addNode(Event node){
        nextNodes.add(node);
    }

    /**
     * Affiche le noeud de décision sur l'interface utilisateur.
     *
     * @param pnlRoot Le JPanel racine de la fenêtre.
     */
    @Override
    public void display(JPanel pnlRoot) {
        super.display(pnlRoot);
    }


    /**
     * Permet à l'utilisateur de choisir le noeud suivant parmi les options disponibles.
     *
     * @param pnlRoot    Le JPanel de la fenêtre.
     * @param personnage Le personnage associé à la décision.
     * @return Un noeud de type Event, correspondant au choix de l'utilisateur.
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
        buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
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
    /**
     * Renvoie la liste des noeuds suivants possibles à partir de ce noeud de décision.
     *
     * @return La liste des noeuds suivants possibles.
     */
    @Override
    public List<Event> getNextNodes() {
        return nextNodes;
    }
}

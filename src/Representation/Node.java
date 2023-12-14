// Node.java
package Representation;

import Univers.Personnage;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;

public abstract class Node implements Event, Serializable {
    private final int id;
    private String description;
    private static int nbNodes = 0;
    protected JLabel jLabel;
    protected static final Object lock = new Object();
    static JButton nextButton = new JButton("Suivant");



    public Node(String description) {
        this.id = nbNodes;
        this.description = description;
        nbNodes++;
    }

    public Node() {
        this.id = nbNodes;
        nbNodes++;
    }

    public void display(JPanel pnlRoot) {
//        if(id == 0){
//            JPanel nestedPanel = (JPanel) pnlRoot.getComponent(1);
//            JButton button = (JButton) nestedPanel.getComponent(0);
//            JButton button1 = (JButton) nestedPanel.getComponent(2);
//            JFrameFunctionnalities.waitForSelection(new JButton[]{button, button1}, nestedPanel);
//
//        }
//        else {
            pnlRoot.removeAll();
            pnlRoot.setLayout(new BorderLayout());

            JLabel jLabel = new JLabel(this.description);
            jLabel.setFont(new Font("Minecraftia", Font.PLAIN, 30));
            jLabel.setHorizontalAlignment(SwingConstants.CENTER);
            pnlRoot.add(jLabel, BorderLayout.NORTH); // Ajouter le JLabel en haut du BorderLayout

            nextButton(pnlRoot);
//        }
    }

    public static void  nextButton(JPanel pnlRoot) {
        pnlRoot.revalidate();
        pnlRoot.repaint();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(nextButton);
        pnlRoot.add(nextButton,BorderLayout.SOUTH);
        pnlRoot.revalidate();
        pnlRoot.repaint();
        JFrameFunctionnalities.waitForSelection(nextButton,pnlRoot);
    }

    public abstract Event chooseNext(JPanel pnlRoot, Personnage personnage);

    public String getDescription() {
        return this.description;
    }

    public List<Event> getNextNodes() {
        return null;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return obj.getClass() == this.getClass();
        }
        return false;
    }

    public static int getNbNodes() {
        return nbNodes;
    }
}

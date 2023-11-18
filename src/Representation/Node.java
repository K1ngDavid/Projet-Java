package Representation;

//TODO: #3 Création de la classe mère 'Node.java'

import javax.swing.*;
import java.awt.*;
import java.util.List;

/** Abstract class Node
 * @author k1ngdavid
 * @version 1.0.0
 * @since October 2023
 * */


public abstract class Node implements Event {
    private final int id;
    private String description;
    private static int nbNodes = 0;
    protected JLabel jLabel;


    /**
     * @param description the description of the node
     */
    public Node(String description) {
        this.id = nbNodes;
        this.description = description;
        jLabel = new JLabel(this.description);
        nbNodes++;
    }
    public Node() {
        this.id = nbNodes;
        nbNodes++;
    }

    /**
     * displays the description of the node
     */
    public void display(JPanel pnlRoot) {
        System.out.println("Jlabel ----> " + this.jLabel.getText());
        pnlRoot.removeAll();
        jLabel = new JLabel(this.description);
        jLabel.setFont(new Font("Arial",Font.PLAIN,30));
        pnlRoot.add(jLabel); // Add the label to the panel
        pnlRoot.revalidate();
        pnlRoot.repaint();
        System.out.println("++++" + this.description);
    }

    /**
     * @return total number of nodes.
     * @deprecated
     */
    public static int getNbNodes() {
        return nbNodes;
    }


    /**
     * @return id of the node
     */
    public int getId(){
        return this.id;
    }

    /**
     * @return description of node
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return the next node of the current node
     */
    @Override
    public Event chooseNext() {
        return null;
    }

    public List<Event> getNextNodes() {
        return null;
    }

    /**
     * @return all the information about the node by overriding the toString() method of the Object class
     */
    /*ANCIENNE VERSION
    @Override
    public String toString() {
        return "Node de type : " + this.getClass() + "\nId : " + this.getId() + "\nDescription : " + this.getDescription();
    }
    */
    @Override
    public String toString() {
        return this.getDescription();
    }

    /**
     * @param obj object that we want to compare
     * @return true if the class of the object passed in params is equal to the class of the current node
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return obj.getClass() == this.getClass();
        }
        return false;
    }
}

package Representation;

//TODO: #3 Création de la classe mère 'Node.java'

import java.util.ArrayList;
import java.util.List;

/** Abstract class Node
 * @author k1ngdavid
 * @version 1.0.0
 * @since October 2023
 * */


public abstract class Node implements Event {
    private final int id;
    private final String description;
    private static int nbNodes = 0;


    /**
     * @param description the description of the node
     */
    public Node(String description) {
        this.id = nbNodes;
        this.description = description;
        nbNodes++;
    }

    /**
     * displays the description of the node
     */
    public void display() {
        System.out.println(this.description);
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
    @Override
    public String toString() {
        return "Node de type : " + this.getClass() + "\nId : " + this.getId() + "\nDescription : " + this.getDescription();
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

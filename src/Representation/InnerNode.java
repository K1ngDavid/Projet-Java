package Representation;

import Univers.Personnage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class InnerNode extends Node {

    protected List<Event> nextNodes;
    public InnerNode(String description) {
        super(description);
        this.nextNodes = new ArrayList<>(4);
        //TODO Auto-generated constructor stub
    }

    public InnerNode(String description, List<Event> nexNodes){
        super(description);
        this.nextNodes = nexNodes;
    }

    public void addNode(Node node){
        this.nextNodes.add(node);
    }

    public abstract Event chooseNext(JPanel pnlRoot, Personnage personnage);

    @Override
    public List<Event> getNextNodes() {
        return nextNodes;
    }
}

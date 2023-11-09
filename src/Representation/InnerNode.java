package Representation;

import java.util.ArrayList;
import java.util.List;

public abstract class InnerNode extends Node implements Event{

    protected List<Node> nextNodes;
    public InnerNode(String description) {
        super(description);
        this.nextNodes = new ArrayList<>(4);
        //TODO Auto-generated constructor stub
    }

    public InnerNode(String description, List<Node> nexNodes){
        super(description);
        this.nextNodes = nexNodes;
    }

    public void addNode(Node node){
        this.nextNodes.add(node);
    }

    @Override
    public List<Node> getNextNodes() {
        return nextNodes;
    }
}

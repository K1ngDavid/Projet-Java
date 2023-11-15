package Representation;

public abstract class DecoratorNode implements Event{

    protected String filePath;
    protected Node node;
    public DecoratorNode(Node node,String filePath) {
        this.node = node;
        this.filePath = filePath;
    }
}

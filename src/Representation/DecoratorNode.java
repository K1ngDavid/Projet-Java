package Representation;

public abstract class DecoratorNode implements Event{

    protected String filePath;
    protected Event node;
    public DecoratorNode(Event node,String filePath) {
        this.node = node;
        this.filePath = filePath;
    }
}

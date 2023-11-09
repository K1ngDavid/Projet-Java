package Representation;

public abstract class Displayable extends Node implements Event{

    /**
     * @param description the description of the node
     */
    public Displayable(String description) {
        super(description);
    }

    @Override
    public void display() {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public Node chooseNext() {
        return null;
    }
}

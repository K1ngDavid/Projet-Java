package Representation;

public class SoundNode extends DecoratorNode{


    public SoundNode(Node node, String filePath) {
        super(node, filePath);
    }

    /**
     * @return
     */
    @Override
    public Event chooseNext() {
        return null;
    }

    /**
     *
     */
    @Override
    public void display() {

    }

    /**
     * @param nodeFromJson
     */
    @Override
    public void addNode(Event nodeFromJson) {

    }
}

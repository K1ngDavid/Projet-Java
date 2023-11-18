package Representation;

//TODO : Création de 'TerminalNode.java'

public class TerminalNode extends Node {

    public TerminalNode(String description) {
        super(description);
        //TODO Auto-generated constructor stub
    }
    public TerminalNode() {
        super();
        //TODO Auto-generated constructor stub
    }



    @Override
    public Event chooseNext() {
        return this;
    }

    /**
     * @param nodeFromJson
     */
    @Override
    public void addNode(Event nodeFromJson) {

    }

}

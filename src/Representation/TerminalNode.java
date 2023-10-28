package Representation;

//TODO : Création de 'TerminalNode.java'

public class TerminalNode extends Node implements Event {

    public TerminalNode(String description) {
        super(description);
        //TODO Auto-generated constructor stub
    }



    @Override
    public Node chooseNext() {
        return this;
    }
}

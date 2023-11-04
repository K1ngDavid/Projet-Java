import Representation.TerminalNode;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args){
        TerminalNode node = new TerminalNode("Dernier Node");
        node.display();
        System.out.println(TerminalNode.getNbNodes());
    }
}

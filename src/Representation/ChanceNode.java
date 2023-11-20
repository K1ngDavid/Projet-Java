package Representation;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ChanceNode extends InnerNode{
    private final List<Event> nextNodes;
    public ChanceNode(String description, List<Event> nextNodes) {
        super(description);
        //TODO Auto-generated constructor stub
        this.nextNodes = nextNodes;
    }
    public  ChanceNode(String description){
        super(description);
        this.nextNodes = new ArrayList<>();
    }

    @Override
    public void addNode(Node node) {
        this.nextNodes.add(node);
    }


    @Override
    public Event chooseNext(JPanel pnlRoot) {
        Random random = new Random();
        System.out.println(nextNodes.size());
        int randomChoice = random.nextInt(nextNodes.size());

        System.out.println("Un événement aléatoire se produit...");

        Event selectedNode = nextNodes.get(randomChoice);
        System.out.println("Vous êtes dirigé vers : " + ((Node) selectedNode).getDescription() );

        return  selectedNode;
    }

    @Override
    public void display(JPanel pnlRoot) {

    }

    /**
     * @param nodeFromJson
     */
    @Override
    public void addNode(Event nodeFromJson) {

    }
}

package Representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ChanceNode extends InnerNode implements Event {
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
    public Event chooseNext() {
        Random random = new Random();
        System.out.println(nextNodes.size());
        int randomChoice = random.nextInt(nextNodes.size());

        System.out.println("Un événement aléatoire se produit...");

        Event selectedNode = nextNodes.get(randomChoice);
        System.out.println("Vous êtes dirigé vers : " + ((Node) selectedNode).getDescription() );

        return  selectedNode;
    }

    /**
     * @param nodeFromJson
     */
    @Override
    public void addNode(Event nodeFromJson) {

    }
}

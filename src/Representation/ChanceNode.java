package Representation;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ChanceNode extends InnerNode{
    private final List<Event> nextNodes;
    private final ImageIcon image = new ImageIcon("src/Images/dice-gif.gif");
    JLabel imageLabel = new JLabel("",image,JLabel.CENTER);
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
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());

        // Display possible successor choices
        try {
            displaySuccessorChoices(pnlRoot);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        pnlRoot.removeAll();
        Random random = new Random();
        int randomChoice = random.nextInt(nextNodes.size());

        System.out.println("Un événement aléatoire se produit...");
        JLabel jLabel1 = new JLabel("Vous êtes redirigés vers : " + nextNodes.get(randomChoice).toString());
        jLabel1.setFont(new Font("Minecraftia", Font.PLAIN, 60));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        pnlRoot.add(jLabel1,BorderLayout.NORTH);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        pnlRoot.add(imageLabel,BorderLayout.CENTER);
        Node.nextButton(pnlRoot);

        return nextNodes.get(randomChoice);
    }

    private void displaySuccessorChoices(JPanel pnlRoot) throws InterruptedException {
        JPanel choicesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        for (Event node : nextNodes) {
            JButton choiceButton = new JButton("Choix : " + node.toString());
            choiceButton.setPreferredSize(new Dimension(300, 300)); // Adjust the size as needed
            choicesPanel.add(choiceButton);
        }

        pnlRoot.removeAll(); // Remove all previous components
        JLabel lbl = new JLabel("Un événement aléatoire se produit...");
        lbl.setFont(new Font("Arial",Font.PLAIN,30));
        lbl.setHorizontalAlignment(0);
        pnlRoot.add(lbl, BorderLayout.NORTH);
        choicesPanel.setPreferredSize(new Dimension(400,400));
        pnlRoot.add(choicesPanel, BorderLayout.CENTER);
        choicesPanel.setOpaque(false);
        pnlRoot.revalidate();
        pnlRoot.repaint();
        TimeUnit.SECONDS.sleep(3);
        lbl.setVisible(false);
    }




    @Override
    public void display(JPanel pnlRoot) {
        super.display(pnlRoot);
    }

    /**
     * @param nodeFromJson
     */
    @Override
    public void addNode(Event nodeFromJson) {
        this.nextNodes.add(nodeFromJson);
    }
}

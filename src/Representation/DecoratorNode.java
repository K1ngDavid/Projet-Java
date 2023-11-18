package Representation;

import javax.swing.*;
import java.awt.*;

public abstract class DecoratorNode implements Event{

    protected String filePath;
    protected Event node;
    protected JLabel jLabel;
    public DecoratorNode(Event node,String filePath) {
        this.node = node;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return node.toString();
    }


    public void display(JPanel pnlRoot,String description) {
        jLabel = new JLabel(description);
        jLabel.setFont(new Font("Arial",Font.PLAIN,30));
        pnlRoot.add(jLabel); // Add the label to the panel
        pnlRoot.revalidate();
    }
}

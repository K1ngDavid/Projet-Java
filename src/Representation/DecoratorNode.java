package Representation;

import Univers.Personnage;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public abstract class DecoratorNode implements Event, Serializable {

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

    @Override
    public int getId() {
        return node.getId();
    }

    @Override
    public Event chooseNext(JPanel jPanel, Personnage personnage) {
        return node.chooseNext(jPanel, personnage);
    }

    @Override
    public void addNode(Event nodeFromJson) {
        node.addNode(nodeFromJson);
    }

    public void display(JPanel pnlRoot, String description) {
        jLabel = new JLabel(description);
        jLabel.setFont(new Font("Arial",Font.PLAIN,30));
        pnlRoot.add(jLabel); // Add the label to the panel
        pnlRoot.revalidate();
    }
}

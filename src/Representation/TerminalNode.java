package Representation;

//TODO : Création de 'TerminalNode.java'

import Univers.Personnage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminalNode extends Node {

    private final JLabel lblGameOver = new JLabel("Game Over",SwingConstants.CENTER);
    private transient ImageIcon imgGameOver = new ImageIcon("src/Images/GAME_OVER.png");

    public TerminalNode(String description) {
        super(description);
        //TODO Auto-generated constructor stub
    }
    public TerminalNode() {
        super();
        //TODO Auto-generated constructor stub
    }



    @Override
    public Event chooseNext(JPanel pnlRoot, Personnage personnage) {
        return this;
    }

    @Override
    public void display(JPanel pnlRoot,Personnage personnage) {
        pnlRoot.removeAll();
        super.display(pnlRoot,personnage);
        pnlRoot.setLayout(new BorderLayout());
        pnlRoot.add(new JLabel(""),BorderLayout.PAGE_START);
        pnlRoot.add(lblGameOver, BorderLayout.CENTER);
        nextButton.setText("Fermer");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        pnlRoot.validate();
        pnlRoot.repaint();
    }

    /**
     * @param nodeFromJson
     */
    @Override
    public void addNode(Event nodeFromJson) {

    }

}

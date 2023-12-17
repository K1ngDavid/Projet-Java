package Representation;

import Game.GamePanel;
import Univers.Personnage;

import javax.swing.*;
import java.awt.*;

public class CombatNode extends InnerNode{
    private transient GamePanel gamePanel;
    private static final Object lock = new Object();
    public CombatNode(String description) {
        super(description);
        this.gamePanel = new GamePanel();
    }

    @Override
    public void addNode(Event nodeFromJson) {
        nextNodes.add(nodeFromJson);
    }

    @Override
    public Event chooseNext(JPanel pnlRoot, Personnage personnage) {
        if(gamePanel == null){
            gamePanel = new GamePanel();
        }
        System.out.println("Image du personnage ----> " + personnage.getImagePersonnage());
        gamePanel.player.setImages(personnage.getImagePersonnage(),personnage.getImagePersonnage());
        gamePanel.setLayout(new BorderLayout());
        JButton startGame = new JButton("START GAME");
        gamePanel.add(startGame,BorderLayout.SOUTH);
        pnlRoot.add(gamePanel,BorderLayout.CENTER);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.startGameThread();

        while(!gamePanel.isFinished)
            Node.nextButton(pnlRoot);
        gamePanel.stopGameThread();
        return this.nextNodes.get(0);
    }

    @Override
    public void display(JPanel pnlRoot) {
        super.display(pnlRoot);
    }
}

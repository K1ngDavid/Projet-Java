package Representation;

import Game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class CombatNode extends InnerNode{
    private GamePanel gamePanel;
    public CombatNode(String description) {
        super(description);
        this.gamePanel = new GamePanel();
    }

    @Override
    public void addNode(Event nodeFromJson) {
        nextNodes.add(nodeFromJson);
    }

    @Override
    public Event chooseNext(JPanel pnlRoot) {
        gamePanel.setLayout(new BorderLayout());
        JButton startGame = new JButton("START GAME");
        gamePanel.add(startGame,BorderLayout.SOUTH);
        pnlRoot.add(gamePanel,BorderLayout.CENTER);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.startGameThread();
        startGame.addActionListener(e -> {
            gamePanel.setBackground(Color.black);

        });
        Node.nextButton(pnlRoot);
        return this.nextNodes.get(0);
    }

    @Override
    public void display(JPanel pnlRoot) {
        super.display(pnlRoot);

    }
}

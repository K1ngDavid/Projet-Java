package Representation;

import Game.GamePanel;
import Univers.Personnage;

import javax.swing.*;
import java.awt.*;

public class CombatNode extends InnerNode{
    private transient GamePanel gamePanel;
    private static final Object lock = new Object();
    private JLabel jLabel = new JLabel("Touches du joueur");
    private JLabel jLabel1 = new JLabel();
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
        gamePanel.player.setImages(personnage.getImagePersonnage(),personnage.getImagePersonnage());
        gamePanel.setLayout(new BorderLayout());
        pnlRoot.add(gamePanel,BorderLayout.CENTER);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.startGameThread();

        while(!gamePanel.isFinished)
            Node.nextButton(pnlRoot);
        return this.nextNodes.get(0);
    }

    @Override
    public void display(JPanel pnlRoot) {
//        super.display(pnlRoot);
        pnlRoot.removeAll();
        jLabel.setFont(new Font("Minecraftia", Font.PLAIN, 30));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pnlRoot.add(jLabel,BorderLayout.NORTH);
        jLabel1.setText("Vous allez entrer dans un CombatNode (noeud de combat), voici quelques instructions pour vous déplacer, bonne chance !<br/>");
        JLabel jLabel2 = new JLabel("<html>z -> aller en haut<br/>\n" +
                "s -> aller en bas<br/>\n" +
                "d -> aller à droite<br/>\n" +
                "q -> aller à gauche<br/></html>");
        jLabel1.setHorizontalAlignment(0);
        jLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel1.setBorder(BorderFactory.createLineBorder(Color.black));
        jLabel2.setHorizontalAlignment(0);
        jLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        jLabel2.setBorder(BorderFactory.createLineBorder(Color.black));
        jLabel2.setFont(new Font("Arial",Font.PLAIN,20));
        pnlRoot.add(jLabel1,BorderLayout.CENTER);
        pnlRoot.add(jLabel2,BorderLayout.CENTER);
        Node.nextButton(pnlRoot);
    }

}

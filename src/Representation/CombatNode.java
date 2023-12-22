package Representation;

import  Game.GamePanel;
import Univers.Personnage;

import javax.swing.*;
import java.awt.*;

/**
 * Représente un nœud de combat dans le scénario du jeu.
 * Étend la classe abstraite InnerNode.
 * @author David Roufé
 */
public class CombatNode extends InnerNode{
    private transient GamePanel gamePanel;
    private JLabel jLabel = new JLabel("Touches du joueur");
    private JLabel jLabel1 = new JLabel();
    /**
     * Constructeur de la classe CombatNode.
     *
     * @param description Description du nœud de combat.
     */
    public CombatNode(String description) {
        super(description);
        this.gamePanel = new GamePanel();
    }

    /**
     * Ajoute un nœud à la liste des nœuds suivants.
     *
     * @param nodeFromJson Nœud à ajouter.
     */
    @Override
    public void addNode(Event nodeFromJson) {
        nextNodes.add(nodeFromJson);
    }

    /**
     * Choisi le prochain nœud en fonction de la situation du jeu.
     *
     * @param pnlRoot      Le panneau racine.
     * @param personnage   Le personnage du joueur.
     * @return             Le prochain nœud.
     */
    @Override
    public Event chooseNext(JPanel pnlRoot, Personnage personnage) {
        if(gamePanel == null){
            gamePanel = new GamePanel();
        }

        if(this.getDescription().contains("Vaincre")){
            //La il faut créer le combat contre le boss
        }

        gamePanel.player.setPersonnage(personnage);
        System.out.println(personnage.getImagePersonnage());

        gamePanel.setLayout(new BorderLayout());
        pnlRoot.add(gamePanel,BorderLayout.CENTER);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.setUpGame();
        gamePanel.startGameThread();

        while(!gamePanel.isFinished)
            Node.nextButton(pnlRoot);

        if(!personnage.estVivant()){
            return this.nextNodes.get(1);
        }
        return this.nextNodes.get(0);
    }

    /**
     * Affiche des informations lors de l'affichage du nœud.
     *
     * @param pnlRoot      Le panneau racine.
     * @param personnage   Le personnage du joueur.
     */
    @Override
    public void display(JPanel pnlRoot,Personnage personnage) {
//        super.display(pnlRoot,personnage);
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

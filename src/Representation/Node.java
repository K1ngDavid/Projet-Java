// Node.java
package Representation;

import Univers.Personnage;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.List;


/**
 * Classe Node, classe mère de tous les noeuds, elle est abstraite car on ne l'utilise pas directement, on utilise ses enfants
 * La classe implémente Event et Serializable
 * @author David Roufé
 */
public abstract class Node implements Event, Serializable {
    private final int id;
    private String description;
    private static int nbNodes = 0;
    protected JLabel jLabel;
    private JLabel imageLabel;
    private transient ImageIcon image;
    protected static final Object lock = new Object();
    public JPanel pnlNorth = new JPanel();
    static JButton nextButton = new JButton("Suivant");
    private  JLabel checkpointLabel = new JLabel("Vous avez atteint un nouveau checkpoint !");
    private  JLabel personnageLabel = new JLabel();


    /**
     * Constructeur la classe Node avec un paramètre description
     * @param description
     */
    public Node(String description) {
        this.id = nbNodes;
        this.description = description;
        nbNodes++;
    }

    /**
     * Constructeur par défaut de la classe Node, si l'on a pas de description associée
     */
    public Node() {
        this.description = "";
        this.id = nbNodes;
        nbNodes++;
    }

    /**
     * Méthode display, elle affiche le noeud sur l'interface.
     * @param pnlRoot de type JPanel
     */
    public void display(JPanel pnlRoot,Personnage personnage) {
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());
        checkpointLabel.setHorizontalAlignment(0);
        checkpointLabel.setFont(new Font("Arial",Font.PLAIN,30));

        jLabel = new JLabel(this.description);
        pnlRoot.add(jLabel,BorderLayout.NORTH);
        jLabel.setFont(new Font("Minecraftia", Font.PLAIN, 25));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setAlignmentX(0);
        pnlNorth.setLayout(new BorderLayout());

        setPlayerIcon(personnage);

        if(personnage.aEvolue()){
            personnageLabel.setText("<html>Vous avez évolué ! <br/>Vous voila " + personnage.getClass().getSimpleName() + "<br/>Voici vos statistiques :" +personnage +"</html>");
            personnageLabel.setHorizontalAlignment(0);
            personnageLabel.setFont(new Font("Minecraftia",Font.PLAIN,18));
            pnlNorth.add(checkpointLabel);
            pnlNorth.add(personnageLabel);
        }
        pnlNorth.setOpaque(false);
        pnlRoot.add(pnlNorth, BorderLayout.CENTER);

        nextButton(pnlRoot);
    }

    public void setPlayerIcon(Personnage personnage){
        if(!personnage.getImagePersonnage().isEmpty()){
            System.out.println("Hello world");
            System.out.println(personnage.getImagePersonnage());
            image = new ImageIcon(personnage.getImagePersonnage());
            if(personnage.isDemon()) image = new ImageIcon(this.image.getImage().getScaledInstance(60, 80, Image.SCALE_DEFAULT));
            else image = new ImageIcon(this.image.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT));
            imageLabel = new JLabel("",image,SwingConstants.RIGHT);

            pnlNorth.add(imageLabel,BorderLayout.NORTH);
        }
    }

    /**
     * Méthode du bouton suivant, elle affiche le bouton "Suivant" pour chaque noeud
     * @param pnlRoot
     */
    public static void  nextButton(JPanel pnlRoot) {
        pnlRoot.revalidate();
        pnlRoot.repaint();
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(nextButton);
        pnlRoot.add(nextButton,BorderLayout.SOUTH);
        pnlRoot.revalidate();
        pnlRoot.repaint();
        JFrameFunctionnalities.waitForSelection(nextButton,pnlRoot);
    }

    /**
     * Méthode abstraite chooseNext, utilisée par les classes filles pour passer au noeud suivant.
     * @param pnlRoot le JPanel
     * @param personnage le personnage choisit par le personnage
     * @return un objet de type Event (tout objet implémentant l'interface Event)
     * @see Event
     */
    public abstract Event chooseNext(JPanel pnlRoot, Personnage personnage);

    /**
     * Méthode get renvoyant la description du noeud
     * @return description d'un noeud
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Méthode renvoyant la liste des noeuds successeurs
     * @return liste d'objets implémentant l'interface Event
     * @see Event
     */
    public List<Event> getNextNodes() {
        return null;
    }

    /**
     * Méthode renvoyant l'id d'un noeud
     * @return l'id d'un noeud
     */
    public int getId() {
        return id;
    }

    /**
     * Méthode redéfinie de la classe Object et renvoyant sous format textuel un noeud
     * @return un noeud sous la forme d'une chaîne de caractères
     */
    @Override
    public String toString() {
        return this.getDescription();
    }

    /**
     * Méthode redéfinie de la méthode equals de la class Object, elle vérifie si deux noeuds sont de même classe
     * @param obj de type Object
     * @return true si les deux objets sont de même classe, false sinon
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return obj.getClass() == this.getClass();
        }
        return false;
    }

    /**
     * Méthode renvoyant le nombre de noeuds crées
     * @return nombre de noeuds
     */
    public static int getNbNodes() {
        return nbNodes;
    }
}

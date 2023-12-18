package Representation;

import Univers.Personnage;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe ChanceNode, une classe représentant un nœud de chance. Elle étend la classe InnerNode.
 * Les nœuds de chance sont des nœuds qui introduisent un élément aléatoire dans l'histoire,
 * et le joueur peut avoir plusieurs choix de successeurs en fonction du résultat de cet élément aléatoire.
 * La classe implémente Event.
 *
 * @author David Roufé
 */
public class ChanceNode extends InnerNode {
    /** Liste des nœuds suivants possibles à partir de ce nœud de chance. */
    private final List<Event> nextNodes;

    /** Image représentant l'événement aléatoire. */
    private final ImageIcon image = new ImageIcon("src/Images/dice-gif.gif");

    /** Étiquette affichant l'image de l'événement aléatoire. */
    JLabel imageLabel = new JLabel("", image, JLabel.CENTER);

    /**
     * Constructeur de la classe ChanceNode avec une description et une liste de nœuds suivants possibles.
     *
     * @param description La description du nœud de chance.
     * @param nextNodes   La liste des nœuds suivants possibles.
     */
    public ChanceNode(String description, List<Event> nextNodes) {
        super(description);
        this.nextNodes = nextNodes;
    }

    /**
     * Constructeur de la classe ChanceNode avec une description. Initialise la liste des nœuds suivants à une liste vide.
     *
     * @param description La description du nœud de chance.
     */
    public ChanceNode(String description) {
        super(description);
        this.nextNodes = new ArrayList<>();
    }

    /**
     * Ajoute un nœud à la liste des nœuds suivants possibles.
     *
     * @param node Le nœud à ajouter.
     */
    @Override
    public void addNode(Node node) {
        this.nextNodes.add(node);
    }

    /**
     * Méthode permettant au joueur de choisir le nœud suivant en fonction des résultats de l'événement aléatoire.
     * @author Victorien Gbaguidi
     * @param pnlRoot    Le JPanel de la fenêtre.
     * @param personnage Le personnage associé à la décision.
     * @return Un nœud de type Event, correspondant au choix du joueur après l'événement aléatoire.
     */
    @Override
    public Event chooseNext(JPanel pnlRoot, Personnage personnage) {
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());

        // Affichage des choix de successeurs possibles
        try {
            displaySuccessorChoices(pnlRoot);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        pnlRoot.removeAll();
        int randomChoice = new Random().nextInt(7);
        System.out.println("Un événement aléatoire se produit...");
        JLabel jLabel1;
        if (randomChoice <= 4)
            jLabel1 = new JLabel("Vous êtes redirigé vers : " + nextNodes.get(0).toString());
        else
            jLabel1 = new JLabel("Vous êtes redirigé vers : " + nextNodes.get(1).toString());
        jLabel1.setFont(new Font("Minecraftia", Font.PLAIN, 60));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        pnlRoot.add(jLabel1, BorderLayout.NORTH);
        imageLabel.setVerticalAlignment(JLabel.CENTER);

        pnlRoot.add(imageLabel, BorderLayout.CENTER);
        Node.nextButton(pnlRoot);

        if (randomChoice <= 4)
            return nextNodes.get(0);
        return nextNodes.get(1);
    }

    /**
     * Affiche les choix de successeurs possibles en fonction des résultats de l'événement aléatoire.
     *
     * @param pnlRoot Le JPanel de la fenêtre.
     * @throws InterruptedException Si l'interruption du thread est détectée pendant l'attente.
     */
    private void displaySuccessorChoices(JPanel pnlRoot) throws InterruptedException {
        JPanel choicesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        for (Event node : nextNodes) {
            JButton choiceButton = new JButton("Choix : " + node.toString());
            choiceButton.setPreferredSize(new Dimension(300, 300)); // Ajustez la taille selon les besoins
            choicesPanel.add(choiceButton);
        }

        pnlRoot.removeAll(); // Supprime tous les composants précédents
        JLabel lbl = new JLabel("Un événement aléatoire se produit...");
        lbl.setFont(new Font("Arial", Font.PLAIN, 30));
        lbl.setHorizontalAlignment(0);
        pnlRoot.add(lbl, BorderLayout.NORTH);
        choicesPanel.setPreferredSize(new Dimension(400, 400));
        pnlRoot.add(choicesPanel, BorderLayout.CENTER);
        choicesPanel.setOpaque(false);
        pnlRoot.revalidate();
        pnlRoot.repaint();
        TimeUnit.SECONDS.sleep(3);
        lbl.setVisible(false);
    }

    /**
     * Affiche le nœud de chance sur l'interface utilisateur.
     *
     * @param pnlRoot Le JPanel de la fenêtre.
     */
    @Override
    public void display(JPanel pnlRoot,Personnage personnage) {
        super.display(pnlRoot,personnage);
    }

    /**
     * Ajoute un nœud à la liste des nœuds suivants possibles.
     *
     * @param nodeFromJson Le nœud à ajouter.
     */
    @Override
    public void addNode(Event nodeFromJson) {
        this.nextNodes.add(nodeFromJson);
    }
}

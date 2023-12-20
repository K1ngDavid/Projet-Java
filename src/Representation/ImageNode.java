package Representation;

import Univers.Personnage;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * La classe ImageNode est une classe décoratrice qui ajoute une fonctionnalité d'affichage d'image à un nœud existant.
 * Elle étend la classe DecoratorNode et implémente l'interface Event.
 * L'image associée à l'événement est chargée à partir d'un fichier spécifié par le chemin du fichier.
 * Cette classe utilise des méthodes d'IO pour vérifier si le fichier existe et s'il contient une image valide.
 * L'image est redimensionnée pour s'adapter à la mise en page de l'interface utilisateur.
 * Lors de l'affichage, l'image et le texte du nœud décoré sont affichés avec un bouton "Suivant" pour passer à l'événement suivant.
 *
 * @author [Votre Nom]
 */
public class ImageNode extends DecoratorNode {

    private transient ImageIcon image;

    /**
     * Constructeur de la classe ImageNode.
     *
     * @param node     Le nœud à décorer avec une image.
     * @param filePath Le chemin du fichier contenant l'image à afficher.
     */
    public ImageNode(Node node, String filePath) {
        super(node, filePath);
        if (isImageFile(filePath)) {
            this.image = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT));
        }
    }

    /**
     * Vérifie si le fichier spécifié par le chemin est un fichier image valide.
     *
     * @param filePath Le chemin du fichier à vérifier.
     * @return True si le fichier est une image valide, sinon False.
     */
    public static boolean isImageFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException("Le document n'existe pas");
            }
            if (ImageIO.read(new File(filePath)) == null) {
                throw new IOException("Le document existe mais est vide");
            }
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * Affiche l'événement décoré avec son image, son texte et un bouton "Suivant".
     *
     * @param pnlRoot Le JPanel de la fenêtre où afficher l'événement.
     */
    @Override
    public void display(JPanel pnlRoot,Personnage personnage) {
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());

        // Redimensionner l'image pour s'adapter à la mise en page
        image = new ImageIcon(this.image.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT));
        Personnage.setImageFile(filePath);

        // Afficher l'image, le texte du nœud décoré et le bouton "Suivant"
        JLabel lbl = new JLabel("", image, JLabel.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblText = new JLabel(node.toString());
        lblText.setFont(new Font("Arial", Font.PLAIN, 30));
        lblText.setHorizontalAlignment(SwingConstants.CENTER);

        pnlRoot.add(lblText, BorderLayout.NORTH);
        pnlRoot.add(lbl);
        nextButton(pnlRoot);
    }

    /**
     * Ajoute un bouton "Suivant" à l'interface utilisateur.
     *
     * @param pnlRoot Le JPanel de la fenêtre où ajouter le bouton.
     */
    private void nextButton(JPanel pnlRoot) {
        JButton nextButton = new JButton("Suivant");
        pnlRoot.add(nextButton, BorderLayout.SOUTH);
        JFrameFunctionnalities.waitForSelection(nextButton, pnlRoot);
    }

    /**
     * Renvoie le nœud suivant à afficher.
     *
     * @param pnlRoot    Le JPanel de la fenêtre.
     * @param personnage Le personnage associé à la décision.
     * @return Le nœud suivant.
     */
    @Override
    public Event chooseNext(JPanel pnlRoot, Personnage personnage) {
        return node.chooseNext(pnlRoot, personnage);
    }

    /**
     * Renvoie la liste des nœuds suivants possibles (non utilisée dans cette classe).
     *
     * @return null.
     */
    @Override
    public List<Event> getNextNodes() {
        return null;
    }

    /**
     * Renvoie l'image associée à l'événement décoré.
     *
     * @return L'image associée à l'événement.
     */
    public Image getImage() {
        return image.getImage();
    }
}

package Representation;

import Univers.Personnage;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * La classe SoundNode est une classe décoratrice qui ajoute une fonctionnalité de lecture de son à un nœud existant.
 * Elle étend la classe DecoratorNode et implémente l'interface Event.
 * La classe utilise la bibliothèque Java Sound pour jouer un fichier audio spécifié par le chemin du fichier.
 * Le fichier audio doit être dans un format pris en charge par Java Sound (wav, au, aif, etc.).
 * La classe utilise la classe Clip pour jouer le son.
 * Lors de l'affichage, le son est joué et, si le nœud décoré est un TerminalNode, son affichage est également effectué.
 *
 * @author [Votre Nom]
 */
public class SoundNode extends DecoratorNode {

    private transient Clip clip;

    /**
     * Constructeur de la classe SoundNode.
     *
     * @param node     Le nœud à décorer avec la lecture de son.
     * @param filePath Le chemin du fichier audio à jouer.
     * @throws LineUnavailableException Si la ligne audio n'est pas disponible.
     * @throws IOException              Si une erreur d'entrée/sortie survient.
     */
    public SoundNode(Node node, String filePath) throws LineUnavailableException, IOException {
        super(node, filePath);
        setClip();
    }

    /**
     * Lance la lecture du son et affiche le nœud décoré (si c'est un TerminalNode).
     *
     * @param pnlRoot    Le JPanel de la fenêtre où afficher le nœud.
     * @param personnage Le personnage associé à la décision.
     */
    @Override
    public void display(JPanel pnlRoot,Personnage personnage) {
        System.out.println(this.filePath);
        if(this.clip ==null) setClip();
        this.clip.start();
        if (node instanceof TerminalNode) node.display(pnlRoot,personnage);
    }

    public void setClip(){
        try {
            this.clip = AudioSystem.getClip();
            this.clip.open(AudioSystem.getAudioInputStream(new File(this.filePath)));
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException("Le fichier n'est pas un fichier audio");
        } catch (LineUnavailableException | IOException e) {
            throw new RuntimeException(e);
        }
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
     * Ajoute un nœud à la liste des nœuds suivants du nœud décoré.
     *
     * @param nodeFromJson Le nœud à ajouter.
     */
    @Override
    public void addNode(Event nodeFromJson) {
        node.addNode(nodeFromJson);
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
}

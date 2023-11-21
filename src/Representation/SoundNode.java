package Representation;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SoundNode extends DecoratorNode{

    private Clip clip;

    public SoundNode(Node node, String filePath) throws LineUnavailableException, IOException {
        super(node, filePath);
        try {
            this.clip = AudioSystem.getClip();
            this.clip.open(AudioSystem.getAudioInputStream(new File(this.filePath)));
        }
        catch (UnsupportedAudioFileException e){
            throw new RuntimeException("Le fichier n'est pas un fichier audio");
        }
    }

    /**
     *
     * @param pnlRoot
     * @return
     */
    @Override
    public Event chooseNext(JPanel pnlRoot) {
        return null;
    }

    /**
     *
     * @param pnlRoot
     */
    @Override
    public void display(JPanel pnlRoot) {
        this.clip.start();
        if(node instanceof TerminalNode) node.display(pnlRoot);
    }

    /**
     * @param nodeFromJson
     */
    @Override
    public void addNode(Event nodeFromJson) {
        node.addNode(nodeFromJson);
    }

    /*Ajout Victorien*/
    public List<Event> getNextNodes() {
        return null;
    }
}

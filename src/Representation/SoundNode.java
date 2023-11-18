package Representation;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SoundNode extends DecoratorNode{

    private Clip clip;

    public SoundNode(Node node, String filePath) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        super(node, filePath);
        this.clip = AudioSystem.getClip();
        this.clip.open(AudioSystem.getAudioInputStream(new File(this.filePath)));
    }
    @Override
    public Event chooseNext() {
        return  node.chooseNext();
    }

    /**
     *
     */
    @Override
    public void display() {
        this.clip.start();
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

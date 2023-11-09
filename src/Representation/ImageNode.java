package Representation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class ImageNode extends Displayable{
    /**
     * @param description the description of the node
     */
    private final String imagePath;
    private Image image;

    public ImageNode(String description,String imagePath) {
        super(description);
        this.imagePath = imagePath;
    }

    public void loadImage() throws IOException {
        image = ImageIO.read(new File("/Images/__Run.gif"));
    }

}

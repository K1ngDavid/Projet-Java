package Representation;
import javax.imageio.IIOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class ImageNode extends DecoratorNode{

    private ImageIcon image;

    private static final Object lock = new Object();

    /**
     *
     * @param node ImageNode reçoit en paramètre un Node pour le décorer et lui ajouter des fonctionnalités
     * @param filePath On reçoit en paramètre le chemin du fichier pour ouvrir l'image
     */
    public ImageNode(Node node, String filePath) {
        super(node,filePath);
        if(isImageFile(filePath)){
            this.image = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT));
        }
    }

    /**
     * @external_sources CHATGPT
     * @param filePath
     * @return
     */
    public static boolean isImageFile(String filePath){
        try {
            File file = new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException("Le document n'existe pas");
            }
            if(ImageIO.read(new File(filePath)) == null){
                throw new IOException("Le document existe mais est vide");
            }
            return true;
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    @Override
    public void display(JPanel pnlRoot) {
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());
        image = new ImageIcon(this.image.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT));
        JLabel lbl = new JLabel("", image, JLabel.CENTER);
        lbl.setVerticalAlignment(SwingConstants.CENTER);  // Ajustez la position verticale
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel lblText = new JLabel(node.toString());
        lblText.setFont(new Font("Arial", Font.PLAIN, 30));
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        pnlRoot.add(lblText,BorderLayout.NORTH);  // Ajoutez lblText à la position (0, 0)
        pnlRoot.add(lbl);  // Ajoutez lbl à la position (0, 1);
        nextButton(pnlRoot);
    }

    private void nextButton(JPanel pnlRoot) {
        JButton nextButton = new JButton("Suivant");
        pnlRoot.add(nextButton,BorderLayout.SOUTH);
        JFrameFunctionnalities.waitForSelection(nextButton,pnlRoot);
    }

    @Override
    public Event chooseNext(JPanel pnlRoot) {
        return node.chooseNext(pnlRoot);
    }

    /*Ajout Victorien*/
    public List<Event> getNextNodes() {
        return null;
    }

    public Image getImage(){
        return image.getImage();
    }
}

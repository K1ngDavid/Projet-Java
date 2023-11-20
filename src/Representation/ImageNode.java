package Representation;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
        System.out.println("+++++" + node.getDescription());
        try{
            if(isImageFile(filePath)){
                this.image = new ImageIcon(new ImageIcon(filePath).getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT));
            }else throw new Exception("Le document n'est pas une image :/");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * @external_sources CHATGPT
     * @param filePath
     * @return
     */
    public static boolean isImageFile(String filePath) throws IOException {
        if(ImageIO.read(new File(filePath)) == null){
            return false;
        }
        else return true;
    }
    @Override
    public void display(JPanel pnlRoot) {
        pnlRoot.removeAll();
        image = new ImageIcon(this.image.getImage().getScaledInstance(220, 220, Image.SCALE_DEFAULT));;
        JLabel lbl = new JLabel("",image,JLabel.CENTER);
        lbl.setVerticalAlignment(1/2);
        JLabel lblText= new JLabel("Vous êtes un " + node.toString() + " !!!");
        lblText.setFont(new Font("Arial",Font.PLAIN,30));
        pnlRoot.add(lblText);
        pnlRoot.add(lbl); // Ajoutez le JLabel au JFrame
        nextButton(pnlRoot);

//        JButton nextButton = new JButton("Suivant");
//        pnlRoot.add(nextButton);
//
//        nextButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                synchronized (lock) {
//                    lock.notify(); // Notifie le thread principal pour continuer
//                }
//            }
//        });
//
//        pnlRoot.revalidate();
//        pnlRoot.repaint();
//
//        synchronized (lock) {
//            try {
//                lock.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    private void nextButton(JPanel pnlRoot) {
        JButton nextButton = new JButton("Suivant");
        pnlRoot.add(nextButton);
        pnlRoot.revalidate();
        pnlRoot.repaint();
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (lock) {
                    lock.notify(); // Notifie le thread principal pour continuer
                    System.out.println("Hello WOrld");
                }
            }
        });

        pnlRoot.revalidate();
        pnlRoot.repaint();

        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param nodeFromJson
     */
    @Override
    public void addNode(Event nodeFromJson) {
        node.addNode(nodeFromJson);
    }

    /**
     * @return
     */
    @Override
    public Event chooseNext(JPanel pnlRoot) {
        return node.chooseNext(pnlRoot);
    }

    /*Ajout Victorien*/
    public List<Event> getNextNodes() {
        return null;
    }
}

package Representation;

import Univers.Personnage;

import javax.swing.*;
import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class Sauvegarde extends JFrame implements Serializable  {
    private ArrayList<Event> checkpoints;
    private ArrayList<ArrayList<Event>> partie;
    private Personnage personnage;
    private JPanel pnlSauvegarde = new JPanel();
    boolean isPartieSaved = false;

    public Sauvegarde() throws IOException {
        checkpoints = new ArrayList<>();
        partie = new ArrayList<>();
        personnage = new Personnage();
    }


    public ArrayList<Event> getCheckpoints() {
        return checkpoints;
    }

    public ArrayList<ArrayList<Event>> getPartie() {
        return partie;
    }

    public void setCheckpoints(ArrayList<Event> checkpoints) {
        this.checkpoints = checkpoints;
    }

    public void setPartie(ArrayList<ArrayList<Event>> partie) {
        this.partie = partie;
    }

    public boolean savePartie() throws IOException, InterruptedException {
        isPartieSaved = false;
        JTextField jTextField = new JTextField();
        jTextField.setBounds(200,100,200,30);
        JButton valider = new JButton("Valider !");
        this.setVisible(true);
        this.add(new JLabel("Nommez votre sauvegarde :)"),BorderLayout.NORTH);
        pnlSauvegarde.add(jTextField);
        pnlSauvegarde.add(valider);
        this.add(pnlSauvegarde,BorderLayout.CENTER);
        this.setSize(400,400);
        this.revalidate();
        this.repaint();
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isPartieSaved = true;
            }
        });

        while (!isPartieSaved){
            System.out.println("wait");
            Thread.sleep(300);
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(jTextField.getText() + ".txt")))) {
            oos.writeObject(this);
        }
        return true;
    }

    public static Sauvegarde reprendrePartie() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("sauvegarde.txt")))) {
            return (Sauvegarde) ois.readObject();
        }
    }

    public void setPersonnage(Personnage personnage){
        this.personnage = personnage;
    }

    public Personnage getPersonnage() {
        return personnage;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder(new String());
        for(ArrayList<Event> checkpoint : partie){
            for (Event node : checkpoint){
                description.append(node.toString());
            }
        }
        return description.toString();
    }
}

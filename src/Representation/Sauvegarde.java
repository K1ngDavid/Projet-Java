package Representation;

import javax.swing.text.html.StyleSheet;
import java.io.*;
import java.util.ArrayList;

public class Sauvegarde implements Serializable {
    private ArrayList<Event> checkpoints;
    private ArrayList<ArrayList<Event>> partie;


    public Sauvegarde() throws IOException {
        checkpoints = new ArrayList<>();
        partie = new ArrayList<>();
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

    public void savePartie() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("sauvegarde.txt")))) {
            oos.writeObject(this);
        }
    }

    public static Sauvegarde reprendrePartie() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("sauvegarde.txt")))) {
            return (Sauvegarde) ois.readObject();
        }
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder(new String());
        for(ArrayList<Event> checkpoint : partie){
            for (Event node : checkpoint){
                System.out.println(node);
                description.append(node.toString());
            }
        }
        return description.toString();
    }
}

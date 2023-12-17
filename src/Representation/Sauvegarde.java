package Representation;

import Univers.Personnage;

import javax.swing.*;
import javax.swing.text.html.StyleSheet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Sauvegarde extends JFrame implements Serializable  {
    private ArrayList<Event> checkpoints;
    private ArrayList<File> sauvegardeFiles;
    private volatile Sauvegarde sauvegarde = null;

    public Thread t1;
    private ArrayList<ArrayList<Event>> partie;
    private Personnage personnage;
    private JPanel pnlSauvegarde = new JPanel();
    boolean isPartieSaved = false;
    boolean isPartieRegained = false;

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
        this.add(new JLabel("Nommez votre sauvegarde :)"),BorderLayout.NORTH);
        pnlSauvegarde.setLayout(new BorderLayout());
        pnlSauvegarde.add(jTextField,BorderLayout.NORTH);
        pnlSauvegarde.add(valider,BorderLayout.SOUTH);
        this.setVisible(true);
        this.add(new JLabel("Nommez votre sauvegarde :)"),BorderLayout.NORTH);
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
        // Vérifier si le dossier "Sauvegarde" existe, sinon le créer
        Path sauvegardeDirectory = Paths.get("Sauvegarde");
        if (!Files.exists(sauvegardeDirectory)) {
            Files.createDirectory(sauvegardeDirectory);
        }

        // Construire le chemin complet du fichier dans le dossier "Sauvegarde"
        Path filePath = Paths.get("Sauvegarde", jTextField.getText() + ".txt");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath.toFile()))) {
            oos.writeObject(this);
        }
        return true;
    }

    public Sauvegarde getSauvegarde() {
        return sauvegarde;
    }

    public void reprendrePartie() throws IOException, ClassNotFoundException, InterruptedException {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Choisissez votre sauvegarde :)");
        add(label, BorderLayout.NORTH);
        sauvegardeFiles = loadSauvegardeFiles();
        JPanel sauvegardePanel = new JPanel(new GridLayout(sauvegardeFiles.size(), 1));

        for (File file : sauvegardeFiles) {
            JButton button = new JButton(file.getName());
            button.addActionListener(e -> {
                Thread t1 = new Thread(() -> {
                    try {
                        sauvegarde = loadSauvegarde(file);
                        System.out.println("HELLOOOO");
                    } catch (IOException | ClassNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                t1.start();

                try {
                    t1.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace(); // Gérer l'interruption correctement
                }

                // Le reste de votre logique peut être ajouté ici si nécessaire
                // Utilisez la variable sauvegarde ici
                if (sauvegarde != null) {
                    System.out.println(sauvegarde);
                    this.dispose();
                    // Faites quelque chose avec la sauvegarde...
                }
            });
            sauvegardePanel.add(button);
//            return sauvegarde;
        }

        JScrollPane scrollPane = new JScrollPane(sauvegardePanel);
        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);

        // Utiliser SwingUtilities.invokeLater pour afficher la fenêtre
        SwingUtilities.invokeLater(() -> setVisible(true));
        System.out.println("LA SAUVEGARDE A LA FIN DE LA MÉTHODE " + sauvegarde);
//        return sauvegarde;
    }

    private ArrayList<File> loadSauvegardeFiles() {
        ArrayList<File> files = new ArrayList<>();

        File sauvegardeDirectory = new File("Sauvegarde");
        File[] sauvegardeFiles = sauvegardeDirectory.listFiles();

        if (sauvegardeFiles != null) {
            for (File file : sauvegardeFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    files.add(file);
                }
            }
        }

        return files;
    }


    private Sauvegarde loadSauvegarde(File file) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
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
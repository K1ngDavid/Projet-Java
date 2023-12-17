package Representation;

import Game.GamePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public  class JFrameFunctionnalities extends JFrame {

    protected static final Object lock = new Object();
    private static JButton nextButton = new JButton("Suivant");;
    static Sauvegarde savedPartie = null;
    static boolean isClicked = false;



    private JPanel pnlRoot;

    static void waitForSelection(JButton jButton, JPanel pnlRoot){
        pnlRoot.revalidate();
        pnlRoot.repaint();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (lock){
                    lock.notify();
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

    static void waitForSelection(JButton jButton, JPanel pnlRoot, GamePanel gamePanel){
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (lock){
                    if(gamePanel.isFinished){
                        lock.notify();
                    }
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

    static Sauvegarde waitForSelection(JButton[] buttons, JPanel pnlRoot) throws InterruptedException, IOException {
        Sauvegarde sauvegarde = new Sauvegarde();
        for (JButton jButton : buttons) {
            if(isClicked){
                break;
            }
            jButton.addActionListener(e -> {
                isClicked = true;

                if (jButton.getText().equals("Reprendre depuis une sauvegarde")) {
                    isClicked = false;
                        try {
                            sauvegarde.reprendrePartie();
                            System.out.println("La sauvegarde --> " + sauvegarde.getSauvegarde());
                            savedPartie = sauvegarde.getSauvegarde();
                        } catch (IOException | ClassNotFoundException | InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                }
            });
        }

        pnlRoot.revalidate();
        pnlRoot.repaint();

        while (savedPartie == null) {
            if(isClicked){
                System.out.println("Ca passe");
                return null;
            }
            savedPartie = sauvegarde.getSauvegarde();
            Thread.sleep(300);
        }
        System.out.println(savedPartie);
        return savedPartie;
    }



}

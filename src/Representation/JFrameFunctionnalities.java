package Representation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public  class JFrameFunctionnalities extends JFrame {

    protected static final Object lock = new Object();
    private static JButton nextButton = new JButton("Suivant");;
    static Sauvegarde savedPartie = null;



    private JPanel pnlRoot;

    static void waitForSelection(JButton jButton, JPanel pnlRoot){
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

    static Sauvegarde waitForSelection(JButton[] buttons, JPanel pnlRoot) {
        for (JButton jButton : buttons) {
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    synchronized (lock) {
                        lock.notify();
                        if(jButton.getText().equals("Reprendre depuis une sauvegarde")){
                            Sauvegarde sauvegarde;
                            try {
                                sauvegarde = Sauvegarde.reprendrePartie();
                            } catch (IOException | ClassNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }
                            savedPartie = sauvegarde;
                        }
                    }
                }
            });
        }

        pnlRoot.revalidate();
        pnlRoot.repaint();

        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return savedPartie;
    }


}

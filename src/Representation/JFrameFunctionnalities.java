package Representation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class JFrameFunctionnalities extends JFrame {

    protected static final Object lock = new Object();
    private static JButton nextButton = new JButton("Suivant");;


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


}

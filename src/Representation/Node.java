// Node.java
package Representation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public abstract class Node implements Event {
    private final int id;
    private String description;
    private static int nbNodes = 0;
    protected JLabel jLabel;
    protected static final Object lock = new Object();
    static JButton nextButton = new JButton("Suivant");



    public Node(String description) {
        this.id = nbNodes;
        this.description = description;
        nbNodes++;
    }

    public Node() {
        this.id = nbNodes;
        nbNodes++;
    }

    public void display(JPanel pnlRoot) {
        pnlRoot.removeAll();
        pnlRoot.setLayout(new BorderLayout());

        JLabel jLabel = new JLabel(this.description);
        jLabel.setFont(new Font("Minecraftia", Font.PLAIN, 30));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pnlRoot.add(jLabel, BorderLayout.NORTH); // Ajouter le JLabel en haut du BorderLayout

        nextButton(pnlRoot);
    }

    public static void  nextButton(JPanel pnlRoot) {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        nextButton.setVerticalAlignment(JButton.CENTER);
        buttonPanel.setPreferredSize(new Dimension(100, 50)); // Remplacez 100 et 50 par la taille souhaitée
        buttonPanel.add(nextButton); // Ajouter le bouton au JPanel
        pnlRoot.add(buttonPanel, BorderLayout.SOUTH); // Ajouter le JPanel en bas du BorderLayout
        pnlRoot.revalidate();
        pnlRoot.repaint();
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                synchronized (lock) {
                    lock.notify(); // Notify the main thread to continue
                    System.out.println("Hello World");
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

    public abstract Event chooseNext(JPanel pnlRoot);

    public String getDescription() {
        return this.description;
    }

    public List<Event> getNextNodes() {
        return null;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node) {
            return obj.getClass() == this.getClass();
        }
        return false;
    }
}

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
    protected final Object lock = new Object();

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
        pnlRoot.setLayout(new FlowLayout());
        jLabel = new JLabel(this.description);
        jLabel.setFont(new Font("Minecraftia", Font.PLAIN, 30));
        pnlRoot.add(jLabel);
        System.out.println("++++" + this.description);
        this.nextButton(pnlRoot);
    }

    public void nextButton(JPanel pnlRoot) {
        JButton nextButton = new JButton("Suivant");
        pnlRoot.add(nextButton);
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
                System.out.println("JE SUIS LA");
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

package Representation;

import Univers.Personnage;

import javax.swing.*;
import java.util.List;

public interface Event {

    Event chooseNext(JPanel pnlRoot, Personnage personnage);

    void display(JPanel pnlRoot);

    void addNode(Event nodeFromJson);

    List<Event> getNextNodes();

    String toString();

    public int getId();
}

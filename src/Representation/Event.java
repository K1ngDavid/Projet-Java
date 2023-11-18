package Representation;

import javax.swing.*;
import java.util.List;

public interface Event {

    Event chooseNext();

    void display(JPanel pnlRoot);

    void addNode(Event nodeFromJson);

    List<Event> getNextNodes();

    String toString();
}

package Representation;

import java.util.List;

public interface Event {

    Event chooseNext();

    void display();

    void addNode(Event nodeFromJson);

    List<Event> getNextNodes();

    String toString();
}

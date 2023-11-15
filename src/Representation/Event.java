package Representation;

public interface Event {

    Event chooseNext();

    void display();

    void addNode(Event nodeFromJson);
}

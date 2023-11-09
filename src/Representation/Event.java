package Representation;

public interface Event {

    void display();
    int getId();
    String getDescription();
    Node chooseNext();

}

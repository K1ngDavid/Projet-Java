package Representation;

public interface Event {

    public void display();
    public int getId();
    public String getDescription();
    public void setDescription(String newDescription);
    public Node chooseNext();
}

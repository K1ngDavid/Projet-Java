package Representation;

//TODO: #3 Création de la classe mère 'Node.java'


public abstract class Node implements Event {
    private int id;
    private String description;
    private static int nbNodes = 0;


    public Node(String description) {
        this.id = nbNodes;
        this.description = description;
        nbNodes++;
    }

    public void display() {
        System.out.println(this.description);
    }

    public static int getNbNodes() {
        return nbNodes;
    }


    @Override
    public int getId() {
        return this.id;
    }

    /**
     * @return
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     *
     */
    @Override
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    @Override
    public Node chooseNext() {
        return null;
    }

    @Override
    public String toString() {
        return "Node de type : " + this.getClass() + "\nId : " + this.getId() + "\nDescription : " + this.getDescription();
    }

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Node){
            return obj.getClass() == this.getClass();
        }
        return false;
	}
}

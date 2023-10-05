package Univers;

//TODO: #1 Créer la classe 'Personnage'

public class Personnage {
    private String pseudo;
    private String image;

    public Personnage(String pseudo){
        this.pseudo = pseudo;
    }

    public Personnage(String pseudo, String image){
        this.pseudo = pseudo;
        this.image = image;
    }

    public String getPseudo(){
        return this.pseudo;
    }
}

package Univers;

public class Fantassin extends Soldat{

    public Fantassin(Espece espece,String image){
        super(espece,image);
    }
    public Fantassin(Espece espece){
        super(espece);
        if(this.isEmpereur()){
            image = "src/Images/fantassin_empereur.png";
        }else{
            image = "src/Images/fantassin_demon.png";
        }
    }

    public static Fantassin setFantassin(Personnage personnage){
        personnage = new Fantassin(personnage.getEspece());
        //personnage = new Fantassin();

        if(personnage.isEmpereur()){
            personnage.setStatistiques(5, 10, 5);
            //return personnage;
        }
        else if(personnage.isDemon()){
            personnage.setStatistiques(7, 15, 5);
        }
        return (Fantassin) personnage;
    }
}

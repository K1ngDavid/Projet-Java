package Univers;

public class Fantassin extends Soldat{

    public Fantassin(Espece espece){
        super(espece);
    }

    @Override
    public Personnage setPersonnage(Personnage personnage) {
        personnage = (Fantassin) new Fantassin(personnage.getEspece());
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
//    public static Fantassin setFantassin(Personnage personnage){
//        personnage = (Fantassin) new Fantassin(personnage.getEspece());
//        //personnage = new Fantassin();
//
//        if(personnage.isEmpereur()){
//            personnage.setStatistiques(5, 10, 5);
//            //return personnage;
//        }
//        else if(personnage.isDemon()){
//            personnage.setStatistiques(7, 15, 5);
//        }
//        return (Fantassin) personnage;
//    }
}

package Univers;

public class Fantassin extends Soldat{

    public Fantassin(Espece espece){
        super(espece);
        image = "../Images/Skeleton_Walk.gif";
    }

//    @Override
//    public void setPersonnage(Personnage personnage) {
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
//    }
    public static Fantassin setFantassin(Personnage personnage){
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
}

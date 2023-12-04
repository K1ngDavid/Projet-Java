package Univers;

public class Archer extends Soldat{


    public Archer(Espece espece){
        super(espece);
    }

    @Override
    public Archer setPersonnage(Personnage personnage) {
        personnage = new Archer(personnage.getEspece());
        //personnage = new Archer();
        if(personnage.isEmpereur()){
            personnage.setStatistiques(5, 5, 10);
        }
        else if(personnage.isDemon()){
            personnage.setStatistiques(10, 15, 10);
        }
        return (Archer) personnage;
    }

//    public static Archer setArcher(Personnage personnage){
//        personnage = new Archer(personnage.getEspece());
//        //personnage = new Archer();
//        if(personnage.isEmpereur()){
//            personnage.setStatistiques(5, 5, 10);
//        }
//        else if(personnage.isDemon()){
//            personnage.setStatistiques(10, 15, 10);
//        }
//        return (Archer) personnage;
//    }
}

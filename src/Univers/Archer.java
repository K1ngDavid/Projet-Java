package Univers;

public class Archer extends Soldat{


    public Archer(Espece espece){
        super(espece);
    }

    @Override
    public void setPersonnage(Personnage personnage) {
        personnage = new Archer(personnage.getEspece());
        //personnage = new Archer();
        if(personnage.isEmpereur()){
            personnage.setStatistiques(5, 5, 10);
        }
        else if(personnage.isDemon()){
            personnage.setStatistiques(10, 15, 10);
        }
    }

    public static Archer setArcher(Personnage personnage) {
        Archer archer = new Archer(personnage.getEspece());

        if (personnage.isEmpereur()) {
            archer.setStatistiques(5, 5, 10);
        } else if (personnage.isDemon()) {
            archer.setStatistiques(10, 15, 10);
        }

        return archer;
    }
}

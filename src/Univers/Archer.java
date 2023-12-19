package Univers;

import java.lang.invoke.VarHandle;

public class Archer extends Soldat{


    public Archer(Espece espece){
        super(espece);
    }

    public Archer(Espece espece,String image){
        super(espece,image);
    }

    public static Archer setArcher(Personnage personnage) {
        Archer archer = new Archer(personnage.getEspece(),personnage.getImagePersonnage());

        if (personnage.isEmpereur()) {
            archer.setStatistiques(5, 5, 10);
        } else if (personnage.isDemon()) {
            archer.setStatistiques(10, 15, 10);
        }

        return archer;
    }
}

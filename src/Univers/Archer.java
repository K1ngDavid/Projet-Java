package Univers;

import java.lang.invoke.VarHandle;

public class Archer extends Soldat{


    public Archer(Espece espece){
        super(espece);
        if(this.isEmpereur()){
            image = "src/Images/archer_empereur.png";
        }else{
            image = "src/Images/archer_demon.png";
        }
    }

    public Archer(Espece espece,String image){
        super(espece,image);
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

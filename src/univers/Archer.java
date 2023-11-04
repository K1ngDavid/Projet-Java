package univers;

import univers.demon.Demon;
import univers.empereur.Empereur;

public class Archer extends Soldat{
    public static Archer setArcher(Personnage personnage){
        personnage = new Archer();
        if(personnage instanceof Empereur){
            personnage.setStatistiques(5, 5, 10);
        }
        else if(personnage instanceof Demon){
            personnage.setStatistiques(10, 15, 10);
        }
        return (Archer) personnage;
    }
}

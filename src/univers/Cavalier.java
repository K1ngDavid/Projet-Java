package univers;

import univers.demon.Demon;
import univers.empereur.Empereur;

public class Cavalier extends Soldat{
    public static Cavalier setCavalier(Personnage personnage){
        personnage = new Cavalier();
        if(personnage instanceof Empereur){
            personnage.setStatistiques(10, 10, 5);
        }
        else if(personnage instanceof Demon){
            personnage.setStatistiques(10, 15, 5);
        }
        return (Cavalier) personnage;
    }
}
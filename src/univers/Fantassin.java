package univers;

import univers.demon.Demon;
import univers.empereur.Empereur;

public class Fantassin extends Soldat{

    public static Fantassin setFantassin(Personnage personnage){
        personnage = new Fantassin();
        if(personnage instanceof Empereur){
            personnage.setStatistiques(5, 10, 5);
        }
        else if(personnage instanceof Demon){
            personnage.setStatistiques(7, 15, 5);
        }
        return (Fantassin) personnage;
    }
}

package Univers;

import Univers.demon.Demon;
import Univers.empereur.Empereur;

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

    /**
     * @param personnage
     */
    @Override
    public void attaquer(ActionsPersonnage personnage) {

    }

    /**
     * @param personnage
     */
    @Override
    public void perdrePV(ActionsPersonnage personnage) {

    }

    /**
     * @return
     */
    @Override
    public Personnage evoluerGrade() {
        return null;
    }
}

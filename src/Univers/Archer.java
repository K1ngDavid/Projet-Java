package Univers;

import Univers.demon.Demon;
import Univers.empereur.Empereur;

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

package Univers;

import Univers.demon.*;
import Univers.empereur.*;

public abstract class Capitaine extends Personnage{

    public static General evoluerGrade(Personnage personnage){
        if(personnage instanceof Empereur){
            if(personnage instanceof Epeiste){
                personnage =  new SaintPaladin();
            }
            else if(personnage instanceof Silvios){
                personnage = new MageSaint();
            }
            else if(personnage instanceof Tank){
                personnage = new BerserkerDeLApocalyspse();
            }
        }
        else if(personnage instanceof Demon){
            if(personnage instanceof SilloneurDesTrefonds){
                personnage =  new NemesisDuChaos();
            }
            else if(personnage instanceof Antechrist){
                personnage = new Necromancien();
            }
            else if(personnage instanceof DieuDemon){
                personnage = new CavalierDuNeant();
            }
        }
        personnage = General.faculteSpeciale(personnage);
        return (General) personnage;
    }
}

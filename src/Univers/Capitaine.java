package Univers;

import Univers.demon.*;
import Univers.empereur.*;

public abstract class Capitaine extends Personnage{

    public Capitaine(Espece espece){
        super(espece);
    }

    public static General evoluerGrade(Personnage personnage){
        if(personnage.isEmpereur()){
            if(personnage instanceof Epeiste){
                personnage =  new SaintPaladin();
                personnage = General.faculteSpeciale(personnage);
                return (SaintPaladin) personnage;
            }
            else if(personnage instanceof Silvios){
                personnage = new MageSaint();
                personnage = General.faculteSpeciale(personnage);
                return (MageSaint) personnage;
            }
            else if(personnage instanceof Tank){
                personnage = new BerserkerDeLApocalyspse();
                personnage = General.faculteSpeciale(personnage);
                return (BerserkerDeLApocalyspse) personnage;
            }
        }
        else if(personnage.isDemon()){
            if(personnage instanceof SilloneurDesTrefonds){
                personnage =  new NemesisDuChaos();
                personnage = General.faculteSpeciale(personnage);
                return (NemesisDuChaos) personnage;
            }
            else if(personnage instanceof Antechrist){
                personnage = new Necromancien();
                personnage = General.faculteSpeciale(personnage);
                return (Necromancien) personnage;
            }
            else if(personnage instanceof DieuDemon){
                personnage = new CavalierDuNeant();
                personnage = General.faculteSpeciale(personnage);
                return (CavalierDuNeant) personnage;
            }
        }
        return (General) personnage;
    }
}

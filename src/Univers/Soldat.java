package Univers;

import Univers.empereur.*;
import Univers.demon.*;

public abstract class Soldat extends Personnage {

    public static Capitaine evoluerGrade(Personnage personnage){
        if(personnage instanceof Empereur){
            if(personnage instanceof Fantassin){
                personnage =  new Epeiste();
            }
            else if(personnage instanceof Archer){
                personnage = new Silvios();

            }
            else if(personnage instanceof Cavalier){
                personnage = new Tank();


            }
        }
        else if(personnage instanceof Demon){
            if(personnage instanceof Fantassin){
                personnage =  new SilloneurDesTrefonds();
                personnage.setStatistiques(90, 180, 60);

            }
            else if(personnage instanceof Archer){
                personnage = new Antechrist();
                personnage.setStatistiques(85, 170, 70);

            }
            else if(personnage instanceof Cavalier){
                personnage = new DieuDemon();
                personnage.setStatistiques(70, 140, 100);

            }
        }
        return (Capitaine) personnage;
    }

}

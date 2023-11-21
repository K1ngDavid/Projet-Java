package Univers;

import Univers.empereur.*;
import Univers.demon.*;

public abstract class Soldat extends Personnage {

    public Soldat(Espece espece){
        super(espece);
    }

    public static Capitaine evoluerGrade(Personnage personnage){
        if(personnage.isEmpereur()){
            if(personnage instanceof Fantassin){
                personnage =  new Epeiste();
                return (Epeiste) personnage;
            }
            else if(personnage instanceof Archer){
                personnage = new Silvios();
                return (Silvios) personnage;
            }
            else if(personnage instanceof Cavalier){
                personnage = new Tank();
                return (Tank) personnage;
            }
        }
        else if(personnage.isDemon()){
            if(personnage instanceof Fantassin){
                personnage =  new SilloneurDesTrefonds();
                return (SilloneurDesTrefonds) personnage;

            }
            else if(personnage instanceof Archer){
                personnage = new Antechrist();
                return (Antechrist) personnage;

            }
            else if(personnage instanceof Cavalier){
                personnage = new DieuDemon();
                return (DieuDemon) personnage;

            }
        }
        return (Capitaine) personnage;
    }

}

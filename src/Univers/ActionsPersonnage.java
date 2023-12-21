package Univers;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 * Indique les actions que tout personnage doit pouvoir effectuer
 */
public interface ActionsPersonnage {

    public abstract void attaquer(Personnage personnage);

    //Plus tard : public abstract void attaquerMana(ActionsPersonnage personnage);

    public abstract void perdrePV(int pertePV);

    public abstract Personnage evoluerGrade();
}

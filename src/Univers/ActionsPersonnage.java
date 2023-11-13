package Univers;

public interface ActionsPersonnage {

    public abstract void attaquer(ActionsPersonnage personnage);

    public abstract void perdrePV(int pertePV);

    public abstract Personnage evoluerGrade();
}

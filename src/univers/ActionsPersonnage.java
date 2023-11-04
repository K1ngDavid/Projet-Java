package univers;

public interface ActionsPersonnage {

    public abstract void attaquer(ActionsPersonnage personnage);

    public abstract void perdrePV(ActionsPersonnage personnage);

    public abstract Personnage evoluerGrade();
}
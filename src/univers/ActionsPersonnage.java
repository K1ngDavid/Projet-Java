package univers;

public interface ActionsPersonnage {

    public abstract void attaquer(ActionsPersonnage personnage);

    public abstract void perdrePV(ActionsPersonnage personnage);

    public abstract void gagnerPV(int pV);

    public abstract void mourir();

    public abstract void evoluerGrade();

    public abstract void evoluerClasse();
}
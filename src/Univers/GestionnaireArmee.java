package Univers;

public abstract class GestionnaireArmee {

    private int nombreFantassins;
    private int nombreArchers;
    private int nombreCavaliers;

    private Fantassin fantassinType;
    private Archer archerType;
    private Cavalier cavalierType;

    public GestionnaireArmee(){
        this.nombreFantassins = 0;
        this.nombreArchers = 0;
        this.nombreCavaliers = 0;

        this.fantassinType = new Fantassin();
        this.archerType = new Archer();
        this.cavalierType = new Cavalier();
    }

    public void updateNombreFantassins(int nombreFantassins){
        this.nombreFantassins = nombreFantassins;
    }

    public void updateNombreArchers(int nombreArchers){
        this.nombreArchers = nombreArchers;
    }

    public void updateNombreCavaliers(int nombreCavaliers){
        this.nombreCavaliers = nombreCavaliers;
    }

    public void perteFantassin(int perte){
        this.nombreFantassins-=perte;
    }

    public void perteArcher(int perte){
        this.nombreArchers-=perte;
    }

    public void perteCavalier(int perte){
        this.nombreCavaliers-=perte;
    }

    public void setCaractéristiquesFantassins(int force, int pointDeVie, int mana){
        this.fantassinType.setStatistiques(force, pointDeVie, mana);
    }
    public void setCaractéristiquesArchers(int force, int pointDeVie, int mana){
        this.archerType.setStatistiques(force, pointDeVie, mana);
    }
    public void setCaractéristiquesCavaliers(int force, int pointDeVie, int mana){
        this.cavalierType.setStatistiques(force, pointDeVie, mana);
    }
}

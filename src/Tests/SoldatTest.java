package Tests;

import Univers.*;
import Univers.demon.Antechrist;
import Univers.demon.DieuDemon;
import Univers.demon.SilloneurDesTrefonds;
import Univers.empereur.Epeiste;
import Univers.empereur.Silvios;
import Univers.empereur.Tank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldatTest {

    private Personnage empereur;
    private Personnage demon;

    @BeforeEach
    public void setUp(){
        empereur = new Personnage(Espece.EMPEREUR);
        demon = new Personnage(Espece.DEMON);
    }
    @Test
    void evoluerGrade() {

        assertTrue(Soldat.evoluerGrade(Fantassin.setFantassin(new Personnage(Espece.EMPEREUR))) instanceof Epeiste);
        assertTrue(Soldat.evoluerGrade(Archer.setArcher(new Personnage(Espece.EMPEREUR))) instanceof Silvios);
        assertTrue(Soldat.evoluerGrade(Cavalier.setCavalier(new Personnage(Espece.EMPEREUR))) instanceof Tank);

        assertTrue(Soldat.evoluerGrade(Fantassin.setFantassin(new Personnage(Espece.DEMON))) instanceof SilloneurDesTrefonds);
        assertTrue(Soldat.evoluerGrade(Archer.setArcher(new Personnage(Espece.DEMON))) instanceof Antechrist);
        assertTrue(Soldat.evoluerGrade(Cavalier.setCavalier(new Personnage(Espece.DEMON))) instanceof DieuDemon);
    }
}
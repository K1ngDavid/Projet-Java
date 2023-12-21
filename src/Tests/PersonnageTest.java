package Tests;

import Univers.Personnage;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class PersonnageTest {

    private Personnage personnage;
    @BeforeEach
    public void setUp() {
        personnage = new Personnage();
    }

    @org.junit.jupiter.api.Test
    void perdrePV() {
        personnage.setStatistiques(10, 100, 50);
        personnage.perdrePV(20);
        assertEquals(80, personnage.getPointDeVie());
    }

    @org.junit.jupiter.api.Test
    void mourir() {
        personnage.setStatistiques(10, 100, 50);
        personnage.perdrePV(100);
        assertFalse(personnage.estVivant());
    }

    @org.junit.jupiter.api.Test
    void setStatistiques() {
        personnage.setStatistiques(10, 100, 50);
        assertEquals(10, personnage.getForce());
        assertEquals(100, personnage.getPointDeVie());
        assertEquals(50, personnage.getMana());
    }
}
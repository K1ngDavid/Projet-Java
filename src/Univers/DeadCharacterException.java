package Univers;

/**
 * @author Victorien GBAGUIDI
 * @version Version 1
 * Exception indiquant l'usage d'un personnage mort pour une action quelconque
 */
public class DeadCharacterException extends Exception{
    public DeadCharacterException(String message){
        super(message);
    }
}

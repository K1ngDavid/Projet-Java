import Representation.ImageNode;
import Representation.Node;
import Representation.Sauvegarde;
import Representation.Scenario;
import Univers.Archer;
import Univers.Espece;
import Univers.Personnage;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {
        Scenario scenario = new Scenario();
        try {
            scenario.playScenario(scenario.initialNode);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

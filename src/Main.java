import Representation.ImageNode;
import Representation.Node;
import Representation.Scenario;
import Univers.Archer;
import Univers.Espece;
import Univers.EvoluerPersonnage;
import Univers.Personnage;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scenario scenario = new Scenario();
        try {
            scenario.playScenario(scenario.initialNode);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

//        Personnage personnage = new Personnage();
//        Personnage archerEvolue = EvoluerPersonnage.EvoluerPersonnage(personnage, Archer.class, Espece.EMPEREUR);
//        System.out.println(archerEvolue);
//        ImageNode imageNode = new ImageNode("OK","pl");
//        imageNode.loadImage();
//        ImageNode imageNode = new ImageNode("src/Run.gif");
//        imageNode.display();
    }
}

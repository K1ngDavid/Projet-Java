import Representation.ImageNode;
import Representation.Node;
import Representation.Scenario;
import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scenario scenario = new Scenario();
        scenario.playScenario((Node) scenario.initialNode);
//        ImageNode imageNode = new ImageNode("OK","pl");
//        imageNode.loadImage();
//        ImageNode imageNode = new ImageNode("src/Run.gif");
//        imageNode.display();
    }
}

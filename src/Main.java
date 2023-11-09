import Representation.Node;
import Representation.Scenario;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Scenario scenario = new Scenario();
        scenario.playScenario(scenario.initialNode);
    }
}

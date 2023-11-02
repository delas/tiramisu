package tiramisu;

import tiramisu.model.Backdrop;
import tiramisu.model.ProcessLayer;
import tiramisu.model.Tiramisu;
import tiramisu.model.TiramisuConfiguration;
import tiramisu.view.TiramisuView;

import javax.swing.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TiramisuApplication {
    public static void main(String args[]) throws Exception {

        TiramisuConfiguration configuration = TiramisuConfiguration.readFromJson("examples\\example2.json");
        List<String> dfg = Files.readAllLines(Paths.get("examples\\example1.dfg"));

        Tiramisu tiramisu = new Tiramisu(configuration, dfg);

        JFrame frame = new JFrame("Tiramisu Framework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TiramisuView(tiramisu));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }
}

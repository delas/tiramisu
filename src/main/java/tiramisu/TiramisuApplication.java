package tiramisu;

import tiramisu.model.*;
import tiramisu.view.BackdropView;
import tiramisu.view.TiramisuView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TiramisuApplication {
    public static void main(String args[]) throws Exception {

        TiramisuConfiguration configuration = TiramisuConfiguration.readFromJson("examples\\example1.json");
        List<String> dfg = Files.readAllLines(Paths.get("examples\\example1.dfg"));

        Tiramisu tiramisu = new Tiramisu();
        Backdrop backdrop = configuration.getBackdrop();
        ProcessLayer processLayer = new ProcessLayer();
        tiramisu.setBackdrop(backdrop);
        tiramisu.setProcessLayer(processLayer);
        processLayer.loadFromDFG(dfg, configuration.getActivitiesMap());

        JFrame frame = new JFrame("Tiramisu Framework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TiramisuView(tiramisu));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }
}

package tiramisu;

import tiramisu.model.*;
import tiramisu.view.BackdropView;
import tiramisu.view.TiramisuView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TiramisuApplication {
    public static void main(String args[]) throws Exception {

        TiramisuConfiguration configuration = TiramisuConfiguration.readFromJson("examples\\example1.json");
        String dfg = "5\nbedroom\nkitchen\nbathroom\nentrance\nliving\n1\n0x1\n2\n3x1\n4x1\n0>1x1\n1>2x1\n2>3x1\n0>2x2\n2>1x2\n1>3x1\n1>4x1\n";

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

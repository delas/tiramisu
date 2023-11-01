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

        Random r = new Random();

        Tiramisu tiramisu = new Tiramisu();
        Backdrop backdrop = new Backdrop();
        backdrop.setBackdropPicture("C:\\Users\\andbur\\Desktop\\Backdrop.png");
        ProcessLayer processLayer = new ProcessLayer();
        tiramisu.setBackdrop(backdrop);
        tiramisu.setProcessLayer(processLayer);

        Map<String, Activity> activities = new HashMap<>();
        activities.put("entrance", new Activity("C:\\Users\\andbur\\Desktop\\entrance.png", "Entrance", 640, 60, r.nextDouble(), false));
        activities.put("living", new Activity("C:\\Users\\andbur\\Desktop\\living.png", "Living", 708, 500, r.nextDouble(), false));
        activities.put("bedroom", new Activity("C:\\Users\\andbur\\Desktop\\bed.png", "Bedroom", 36, 430, r.nextDouble(), false));
        activities.put("bathroom", new Activity("C:\\Users\\andbur\\Desktop\\bathroom.png", "Bathroom", 35, 70, r.nextDouble(), false));
        activities.put("kitchen", new Activity("C:\\Users\\andbur\\Desktop\\kitchen.png", "Kitchen", 775, 72, r.nextDouble(), false));

        // load the DFG
        String dfg = "5\nbedroom\nkitchen\nbathroom\nentrance\nliving\n1\n0x1\n2\n3x1\n4x1\n0>1x1\n1>2x1\n2>3x1\n0>2x2\n2>1x2\n1>3x1\n1>4x1\n";
        processLayer.loadFromDFG(dfg, activities);

        JFrame frame = new JFrame("Tiramisu Framework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TiramisuView(tiramisu));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }
}

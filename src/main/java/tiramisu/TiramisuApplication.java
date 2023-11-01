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
        activities.put("bedroom", new Activity("C:\\Users\\andbur\\Desktop\\bed.png", "Bedroom", 36, 430, r.nextDouble(), true));
        activities.put("bathroom", new Activity("C:\\Users\\andbur\\Desktop\\bathroom.png", "Bathroom", 35, 70, r.nextDouble(), false));
        activities.put("kitchen", new Activity("C:\\Users\\andbur\\Desktop\\kitchen.png", "Kitchen", 775, 72, r.nextDouble(), false));

        // load the DFG
        String dfg = "5\nbedroom\nkitchen\nbathroom\nentrance\nliving\n1\n0x1\n2\n3x1\n4x1\n0>1x1\n1>2x1\n2>3x1\n0>2x2\n2>1x2\n1>3x1\n1>4x1\n";
        String[] lines = dfg.split("\n");

        // extract all activities
        int num_activities = Integer.parseInt(lines[0]);
        for(int i = 0; i < num_activities; i++) {
            String activity_name = lines[i+1];
            Activity activity = activities.get(activity_name);
            processLayer.addActivity(activity);
        }

        // extract all edges
        for(int i = num_activities + 1; i < lines.length; i++) {
            String line = lines[i];
            if (line.contains(">")) {
                String[] edge = line.split("\\>");
                int from = Integer.parseInt(edge[0]);
                String[] second_part = edge[1].split("x");
                int to = Integer.parseInt(second_part[0]);
                int count = Integer.parseInt(second_part[1]);
                String activity_from_name = lines[from+1];
                String activity_to_name = lines[to+1];
                Edge e = new Edge(activities.get(activity_from_name), activities.get(activity_to_name), 1, false);
                processLayer.addEdge(e);
            };
        }


//        processLayer.addActivity(entrance);
//        processLayer.addActivity(living);
//        processLayer.addActivity(bedroom);
//        processLayer.addActivity(bathroom);
//        processLayer.addActivity(kitchen);
//
//        processLayer.addEdge(new Edge(bathroom, bedroom, 0, false));
//        processLayer.addEdge(new Edge(bedroom, bathroom, 0, false));
//        processLayer.addEdge(new Edge(entrance, living, 1, false));
//        processLayer.addEdge(new Edge(bedroom, living, 0.5, true));
//        processLayer.addEdge(new Edge(kitchen, bedroom, 0.5, false));



        JFrame frame = new JFrame("Tiramisu Framework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TiramisuView(tiramisu));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}

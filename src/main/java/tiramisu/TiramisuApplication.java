package tiramisu;

import tiramisu.model.*;
import tiramisu.view.BackdropView;
import tiramisu.view.TiramisuView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class TiramisuApplication {
    public static void main(String args[]) throws IOException {

        Random r = new Random();

        Activity entrance = new Activity("C:\\Users\\andbur\\Desktop\\entrance.png", "Entrance", 640, 60, r.nextDouble(), false);
        Activity living = new Activity("C:\\Users\\andbur\\Desktop\\living.png", "Living", 708, 500, r.nextDouble(), false);
        Activity bedroom = new Activity("C:\\Users\\andbur\\Desktop\\bed.png", "Bedroom", 36, 430, r.nextDouble(), true);
        Activity bathroom = new Activity("C:\\Users\\andbur\\Desktop\\bathroom.png", "Bathroom", 35, 70, r.nextDouble(), false);
        Activity kitchen = new Activity("C:\\Users\\andbur\\Desktop\\kitchen.png", "Kitchen", 775, 72, r.nextDouble(), false);

        ProcessLayer processLayer = new ProcessLayer();
        processLayer.addActivity(entrance);
        processLayer.addActivity(living);
        processLayer.addActivity(bedroom);
        processLayer.addActivity(bathroom);
        processLayer.addActivity(kitchen);

        processLayer.addEdge(new Edge(bathroom, bedroom, 0, false));
        processLayer.addEdge(new Edge(entrance, living, 1, false));
        processLayer.addEdge(new Edge(bedroom, living, 0.5, true));
        processLayer.addEdge(new Edge(kitchen, bedroom, 0.5, false));

        Backdrop backdrop = new Backdrop();
        backdrop.setBackdropPicture("C:\\Users\\andbur\\Desktop\\Backdrop.png");

        Tiramisu tiramisu = new Tiramisu();
        tiramisu.setBackdrop(backdrop);
        tiramisu.setProcessLayer(processLayer);

        JFrame frame = new JFrame("Tiramisu Framework");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TiramisuView(tiramisu));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}

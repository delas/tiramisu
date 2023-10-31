package tiramisu;

import tiramisu.model.Activity;
import tiramisu.model.Backdrop;
import tiramisu.model.ProcessLayer;
import tiramisu.model.Tiramisu;
import tiramisu.view.BackdropView;
import tiramisu.view.TiramisuView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TiramisuApplication {
    public static void main(String args[]) throws IOException {

        ProcessLayer processLayer = new ProcessLayer();
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\entrance.png", "Entrance", 640, 60));
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\living.png", "Living", 708, 500));
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\bed.png", "Bedroom", 36, 430));
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\bathroom.png", "Bathroom", 35, 70));
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\kitchen.png", "Kitchen", 775, 72));

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

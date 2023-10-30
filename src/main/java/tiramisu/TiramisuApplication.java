package tiramisu;

import tiramisu.model.Activity;
import tiramisu.model.Backdrop;
import tiramisu.model.ProcessLayer;
import tiramisu.model.Tiramisu;
import tiramisu.view.BackdropView;
import tiramisu.view.TiramisuView;

import javax.swing.*;
import java.io.IOException;

public class TiramisuApplication {
    public static void main(String args[]) throws IOException {

        ProcessLayer processLayer = new ProcessLayer();
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\entrance.png", "Living", 0, 0));
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\living.png", "Living", 100, 100));
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\bed.png", "Living", 200, 100));
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\bathroom.png", "Living", 100, 200));
        processLayer.addActivity(new Activity("C:\\Users\\andbur\\Desktop\\kitchen.png", "Living", 200, 200));

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

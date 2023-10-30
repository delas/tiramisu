package tiramisu.view;

import tiramisu.model.Activity;
import tiramisu.model.ProcessLayer;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ProcessLayerView extends JPanel {

    private ProcessLayer processLayer;
    private List<ActivityView> activityViewList = new LinkedList<>();

    public ProcessLayerView(ProcessLayer processLayer) throws IOException {
        this.processLayer = processLayer;
        for(Activity activity : processLayer.getActivityList()) {
            ActivityView activityView = new ActivityView(activity);
            activityViewList.add(activityView);
        }
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        for(ActivityView aw : activityViewList) {
            g2.drawImage(aw.getImage(), aw.getX(), aw.getY(), this);
        }
    }
}

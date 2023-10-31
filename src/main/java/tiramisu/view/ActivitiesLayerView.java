package tiramisu.view;

import tiramisu.model.Activity;
import tiramisu.model.ProcessLayer;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ActivitiesLayerView extends JPanel {

    private ProcessLayer processLayer;
    private List<ActivityView> activityViewList = new LinkedList<>();

    public ActivitiesLayerView(ProcessLayer processLayer) throws IOException {
        this.processLayer = processLayer;
        setLayout(null);
        setOpaque(false);
        for(Activity activity : processLayer.getActivityList()) {
            ActivityView activityView = new ActivityView(activity);
            activityViewList.add(activityView);
            activityView.setBounds(activityView.getX(), activityView.getY(), activityView.getWidth(), activityView.getHeight());
            add(activityView);
        }
    }
}

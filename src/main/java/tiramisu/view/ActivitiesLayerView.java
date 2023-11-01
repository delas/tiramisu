package tiramisu.view;

import lombok.Getter;
import tiramisu.model.Activity;
import tiramisu.model.ProcessLayer;

import javax.swing.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ActivitiesLayerView extends JPanel {

    private ProcessLayer processLayer;
    @Getter
    private Map<String, ActivityView> activities = new HashMap<>();

    public ActivitiesLayerView(ProcessLayer processLayer) throws IOException {
        this.processLayer = processLayer;
        setLayout(null);
        setOpaque(false);
        for(Activity activity : processLayer.getActivityList()) {
            ActivityView activityView = new ActivityView(activity);
            activities.put(activity.getLabel(), activityView);
            activityView.setBounds(activityView.getX(), activityView.getY(), activityView.getWidth(), activityView.getHeight());
            add(activityView);
        }
    }
}

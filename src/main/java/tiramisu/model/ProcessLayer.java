package tiramisu.model;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class ProcessLayer implements ILayer {

    @Getter
    private List<Activity> activityList = new LinkedList<>();
    @Getter
    private List<Edge> edgesList = new LinkedList<>();

    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void addEdge(Edge edge) {
        edgesList.add(edge);
    }
}

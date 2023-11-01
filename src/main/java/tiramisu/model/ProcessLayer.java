package tiramisu.model;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

    public void loadFromDFG(String dfg, Map<String, Activity> activities) throws Exception {
        String[] lines = dfg.split("\n");

        // extract all activities
        int num_activities = Integer.parseInt(lines[0]);
        for(int i = 0; i < num_activities; i++) {
            String activity_name = lines[i+1];
            Activity activity = activities.get(activity_name);
            addActivity(activity);
        }

        // extract all edges
        int most_frequent_edge = 1;
        for(int i = num_activities + 1; i < lines.length; i++) {
            String line = lines[i];
            if (line.contains(">")) {
                most_frequent_edge = Math.max(most_frequent_edge, Integer.parseInt(line.split("\\>")[1].split("x")[1]));
            }
        }
        // add actual edges
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
                Edge e = new Edge(activities.get(activity_from_name), activities.get(activity_to_name), count/most_frequent_edge, false);
                addEdge(e);
            };
        }
    }
}

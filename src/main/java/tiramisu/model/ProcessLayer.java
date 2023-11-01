package tiramisu.model;

import lombok.Getter;

import java.util.HashMap;
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
        int num_activities = Integer.parseInt(lines[0]);
        int most_frequent_activity = 1;
        int most_frequent_edge = 1;
        Map<String, Integer> activity_to_frequency = new HashMap<>();
        Map<String, Integer> activity_from_frequency = new HashMap<>();

        for(String activity : activities.keySet()) {
            activity_to_frequency.put(activity, 0);
            activity_from_frequency.put(activity, 0);
        }

        // extract most frequent edge and activity frequencies
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

                most_frequent_edge = Math.max(most_frequent_edge, count);
                activity_to_frequency.put(activity_to_name, activity_to_frequency.get(activity_to_name) + count);
                activity_from_frequency.put(activity_from_name, activity_from_frequency.get(activity_from_name) + count);
                most_frequent_activity = Math.max(most_frequent_activity, activity_to_frequency.get(activity_to_name));
                most_frequent_activity = Math.max(most_frequent_activity, activity_from_frequency.get(activity_from_name));
            }
        }

        // add all activities
        for(int i = 0; i < num_activities; i++) {
            String activity_name = lines[i+1];
            Activity activity = activities.get(activity_name);
            double intensity = Math.max(activity_to_frequency.get(activity_name), activity_from_frequency.get(activity_name)) / (double) most_frequent_activity;
            activity.setIntensity(intensity);
            addActivity(activity);
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

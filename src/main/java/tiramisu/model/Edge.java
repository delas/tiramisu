package tiramisu.model;

import lombok.Getter;
import lombok.Setter;

public class Edge {
    @Getter
    private Activity source;
    @Getter
    private Activity target;
    @Getter
    private double intensity;
    @Getter @Setter
    private boolean isDeviation;

    public Edge(Activity source, Activity target, double intensity, boolean isDeviation) throws Exception {
        if (source == null || target == null) {
            throw new Exception("Cannot create an edge with null source or target");
        }
        this.source = source;
        this.target = target;
        this.intensity = intensity;
        this.isDeviation = isDeviation;
    }
}

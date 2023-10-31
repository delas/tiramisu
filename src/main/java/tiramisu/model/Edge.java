package tiramisu.model;

import lombok.Getter;

public class Edge {
    @Getter
    private Activity source;
    @Getter
    private Activity target;
    @Getter
    private double intensity;

    public Edge(Activity source, Activity target, double intensity) {
        this.source = source;
        this.target = target;
        this.intensity = intensity;
    }
}

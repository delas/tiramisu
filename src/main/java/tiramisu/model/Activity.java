package tiramisu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tiramisu.view.ActivityView;

import java.io.File;
import java.util.Random;
import java.util.UUID;

public class Activity {

    private UUID id = UUID.randomUUID();
    @Getter @Setter @JsonProperty("pictogram")
    private String pictogram;
    @Getter @Setter @JsonProperty("label")
    private String label;
    @Getter @Setter @JsonProperty("x")
    private int x;
    @Getter @Setter @JsonProperty("y")
    private int y;
    @Getter @Setter
    private double intensity = 0.0;
    @Getter @Setter
    private boolean isDeviation = false;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Activity) {
            Activity other = (Activity) obj;
            return id.equals(other.id);
        }
        return false;
    }
}

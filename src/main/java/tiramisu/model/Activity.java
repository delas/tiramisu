package tiramisu.model;

import lombok.Getter;
import lombok.Setter;
import tiramisu.view.ActivityView;

import java.io.File;
import java.util.Random;
import java.util.UUID;

public class Activity {

    private UUID id = UUID.randomUUID();
    @Getter
    private String pictogram;
    @Getter
    private String label;
    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private double intensity;
    @Getter @Setter
    private boolean isDeviation = false;

    public Activity(String pictogram, String label, int x, int y, double intensity, boolean isDeviation) {
        this.pictogram = pictogram;
        this.label = label;
        this.x = x;
        this.y = y;
        this.intensity = intensity;
        this.isDeviation = isDeviation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Activity) {
            Activity other = (Activity) obj;
            return id.equals(other.id);
        }
        return false;
    }
}

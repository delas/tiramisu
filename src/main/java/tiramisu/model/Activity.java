package tiramisu.model;

import lombok.Getter;

import java.io.File;
import java.util.Random;
import java.util.UUID;

public class Activity {

    private UUID id = UUID.randomUUID();
    @Getter
    private String pictogram;
    private String label;
    @Getter
    private int x;
    @Getter
    private int y;
    @Getter
    private double intensity;

    public Activity(String pictogram, String label, int x, int y) {
        this.pictogram = pictogram;
        this.label = label;
        this.x = x;
        this.y = y;
        this.intensity = new Random().nextDouble();
    }

    public Activity(String label, int x, int y) {
        this(null, label, x, y);
    }
}

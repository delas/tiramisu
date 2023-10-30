package tiramisu.view;

import lombok.Getter;
import tiramisu.model.Activity;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ActivityView {

    @Getter
    private BufferedImage image;

    @Getter
    private int x;
    @Getter
    private int y;

    public ActivityView(Activity activity) throws IOException {
        image = ImageIO.read(new File(activity.getPictogram()));
    }
}

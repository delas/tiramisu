package tiramisu.view;

import lombok.Getter;
import tiramisu.model.Activity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ActivityView extends JPanel {

    @Getter
    private BufferedImage image;

    @Getter
    private int x;
    @Getter
    private int y;

    public ActivityView(Activity activity) throws IOException {
        image = ImageIO.read(new File(activity.getPictogram()));
        x = activity.getX();
        y = activity.getY();
        setOpaque(false);
    }

    @Override
    public int getWidth() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);
    }
}

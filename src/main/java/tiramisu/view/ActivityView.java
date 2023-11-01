package tiramisu.view;

import lombok.Getter;
import tiramisu.model.Activity;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ActivityView extends JPanel {

    @Getter
    private BufferedImage image;

    @Getter
    private int x;
    @Getter
    private int y;
    private double intensity;
    private boolean mouseOver = false;

    public ActivityView(Activity activity) throws IOException {
        image = ImageIO.read(new File(activity.getPictogram()));
        x = activity.getX();
        y = activity.getY();
        intensity = activity.getIntensity();

        if (!activity.isDeviation() && intensity > 0) {
            BufferedImage dyed = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = dyed.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.setComposite(AlphaComposite.SrcAtop);
            g.setColor(new Color(0, 255, 0, (int) (intensity * 150)));
            g.fillRect(0, 0, image.getWidth(), image.getHeight());
            g.dispose();
            image = dyed;
        }
        if (activity.isDeviation()) {
            BufferedImage dyed = new BufferedImage(image.getWidth(), image.getHeight(),BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = dyed.createGraphics();
            g.drawImage(image, 0, 0, null);
            g.setComposite(AlphaComposite.SrcAtop);
            g.setColor(new Color(255, 0, 0, 50));
            g.fillRect(0, 0, image.getWidth(), image.getHeight());
            g.dispose();
            image = dyed;
        }

        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
                repaint();
            }
        });
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
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawImage(image, 0, 0, this);
        if (mouseOver) {
            g2.setColor(new Color(0, 0, 0));
            g2.setStroke(new BasicStroke(4));
            g2.drawRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 30, 30);
        }
    }
}

package tiramisu.view;

import tiramisu.model.Backdrop;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BackdropView extends JPanel {

    BufferedImage backdropPicture;

    public BackdropView(Backdrop backdrop) throws IOException {
        backdropPicture = ImageIO.read(new File(backdrop.getBackdropPicture()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(backdropPicture, 0, 0, this);
    }
}

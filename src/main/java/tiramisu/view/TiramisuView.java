package tiramisu.view;

import tiramisu.model.Activity;
import tiramisu.model.Tiramisu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TiramisuView extends JPanel {

    private Tiramisu tiramisu;
    private BackdropView backdropView;
    private ProcessLayerView processLayerView;

    public TiramisuView(Tiramisu tiramisu) throws IOException {
        this.backdropView = new BackdropView(tiramisu.getBackdrop());
        this.processLayerView = new ProcessLayerView(tiramisu.getProcessLayer());

        this.add(processLayerView);
        this.add(backdropView);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                backdropView.setBounds(0, 0, getWidth(), getHeight());
                processLayerView.setBounds(0, 0, getWidth(), getHeight());

            }
        });
    }
}

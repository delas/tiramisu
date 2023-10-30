package tiramisu.view;

import tiramisu.model.Tiramisu;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TiramisuView extends JLayeredPane {

    private Tiramisu tiramisu;
    private BackdropView backdropView;

    public TiramisuView(Tiramisu tiramisu) throws IOException {
        this.tiramisu = tiramisu;

        this.backdropView = new BackdropView(tiramisu.getBackdrop());

        this.add(backdropView, 0, 0);
//        this.add(new ProcessLayerView(tiramisu.getProcessLayer()));
    }
}

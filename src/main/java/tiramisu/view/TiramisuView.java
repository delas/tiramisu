package tiramisu.view;

import tiramisu.model.Tiramisu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class TiramisuView extends JLayeredPane {

    private Tiramisu tiramisu;
    private BackdropView backdropView;
    private ProcessLayerView processLayerView;

    public TiramisuView(Tiramisu tiramisu) throws IOException {
        this.tiramisu = tiramisu;

        this.backdropView = new BackdropView(tiramisu.getBackdrop());
        this.processLayerView = new ProcessLayerView(tiramisu.getProcessLayer());

        this.add(processLayerView, 2);
        this.add(backdropView, 1);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                backdropView.setBounds(0, 0, getWidth(), getHeight());
                processLayerView.setBounds(0, 0, getWidth(), getHeight());
            }
        });
    }

}

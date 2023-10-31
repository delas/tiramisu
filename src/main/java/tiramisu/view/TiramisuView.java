package tiramisu.view;

import tiramisu.model.Edge;
import tiramisu.model.Tiramisu;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class TiramisuView extends JPanel {

    private Tiramisu tiramisu;
    private BackdropView backdropView;
    private ActivitiesLayerView activitiesLayerView;
    private EdgesLayerView edgesLayerView;

    public TiramisuView(Tiramisu tiramisu) throws IOException {
        this.backdropView = new BackdropView(tiramisu.getBackdrop());
        this.activitiesLayerView = new ActivitiesLayerView(tiramisu.getProcessLayer());
        this.edgesLayerView = new EdgesLayerView(tiramisu.getProcessLayer());

        this.add(edgesLayerView);
        this.add(activitiesLayerView);
        this.add(backdropView);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                backdropView.setBounds(0, 0, getWidth(), getHeight());
                edgesLayerView.setBounds(0, 0, getWidth(), getHeight());
                activitiesLayerView.setBounds(0, 0, getWidth(), getHeight());
            }
        });
    }
}

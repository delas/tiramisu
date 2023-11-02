package tiramisu.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class Tiramisu {

    @Getter
    private TiramisuConfiguration configuration;
    @Getter
    private Backdrop backdrop;
    @Getter
    private ProcessLayer processLayer;
    @Getter
    private List<ILayer> layers = new LinkedList<ILayer>();

    public Tiramisu(TiramisuConfiguration configuration, List<String> dfg) throws Exception {
        this.configuration = configuration;
        this.backdrop = configuration.getBackdrop();
        this.processLayer = new ProcessLayer();
        this.processLayer.loadFromDFG(dfg, configuration.getActivitiesMap());
    }

}

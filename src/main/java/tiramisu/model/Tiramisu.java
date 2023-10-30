package tiramisu.model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

public class Tiramisu {

    @Getter @Setter
    private Backdrop backdrop;

    @Getter @Setter
    private ProcessLayer processLayer;

    @Getter @Setter
    private List<ILayer> layers = new LinkedList<ILayer>();

}

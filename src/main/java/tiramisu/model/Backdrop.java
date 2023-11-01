package tiramisu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.LinkedList;
import java.util.List;

public class Backdrop {

    @Getter @Setter @JsonProperty("picture")
    private String backdropPicture;
}

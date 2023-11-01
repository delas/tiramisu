package tiramisu.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TiramisuConfiguration {

    @Getter @JsonProperty("activities")
    private List<Activity> activities = new LinkedList<>();
    @Getter @JsonProperty("backdrop")
    private Backdrop backdrop = new Backdrop();

    private TiramisuConfiguration() { }

    public Map<String, Activity> getActivitiesMap() {
        Map<String, Activity> activities = new HashMap<>();
        for (Activity activity : this.activities) {
            activities.put(activity.getLabel(), activity);
        }
        return activities;
    }

    public static TiramisuConfiguration readFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TiramisuConfiguration configuration = objectMapper.readValue(new File(filePath), TiramisuConfiguration.class);
        return configuration;
    }
}

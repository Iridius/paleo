package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Action {
    private final Map<String, Integer> requirements;
    private final Map<String, Integer> success;
    private final Map<String, Integer> fail;

    @JsonCreator
    public Action(@JsonProperty("requirements") Map<String, Integer> requirements,
                  @JsonProperty("success") Map<String, Integer> success,
                  @JsonProperty("fail") Map<String, Integer> fail) {
        this.requirements = requirements;
        this.success = success;
        this.fail = fail;
    }

    public Map<String, Integer> getRequirements() {
        return requirements;
    }

    public Map<String, Integer> getSuccess() {
        return success;
    }

    public Map<String, Integer> getFail() {
        return fail;
    }
}

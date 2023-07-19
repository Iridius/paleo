package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ScenarioDao {
    private final String name;
    private final List<String> modules;

    @JsonCreator
    public ScenarioDao(@JsonProperty("name") String name, @JsonProperty("modules") List<String> modules) {
        this.name = name;
        this.modules = modules;
    }

    public String getName() {
        return name;
    }

    public List<String> getModules() {
        return modules;
    }
}

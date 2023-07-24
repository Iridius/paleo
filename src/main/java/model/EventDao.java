package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EventDao {
    private final String type;
    private final String name;
    private final String background;
    private final List<Action> actions;
    private final boolean assist;

    @JsonCreator
    public EventDao(@JsonProperty("type") String type, @JsonProperty("name") String name,
                    @JsonProperty("background") String background, @JsonProperty("actions") List<Action> actions,
                    @JsonProperty("assist") boolean assist) {
        this.type = type;
        this.name = name;
        this.background = background;
        this.actions = actions;
        this.assist = assist;
    }

    public List<Action> getActions() {
        return actions;
    }

    public String getName() {
        return name;
    }
}

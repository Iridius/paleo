package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class HumanDao {
    private final String name;
    private final int health;
    private final Map<String, Integer> abilities;
    private final int count;

    @JsonCreator
    public HumanDao(@JsonProperty("name") String name,
                    @JsonProperty("health") int health,
                    @JsonProperty("abilities") Map<String, Integer> abilities,
                    @JsonProperty("count") int count) {
        this.name = name;
        this.health = health;
        this.abilities = abilities;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAbilities(String name) {
        return abilities.getOrDefault(name, 0);
    }

    public int getCount() {
        return count;
    }
}

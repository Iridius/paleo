package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ScenarioDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

public class FileModel {
    private final Collection<ScenarioDao> scenarios;

    public FileModel() {
        scenarios = initScenarios();
    }

    private Collection<ScenarioDao> initScenarios() {
        final Collection<ScenarioDao> tiles;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream input = getClass().getClassLoader().getResourceAsStream("scenarios.json");

            tiles = objectMapper.readValue(input, new TypeReference<List<ScenarioDao>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return tiles;
    }

    public ScenarioDao getScenario(String name) {
        for(ScenarioDao scenario: scenarios) {
            if(scenario.getName().equals(name)) {
                return scenario;
            }
        }

        return null;
    }
}

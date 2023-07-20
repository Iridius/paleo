package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ScenarioDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileModel {
    private final Collection<ScenarioDao> scenarios;
    private final Collection<HumanDao> humans;

    public FileModel() {
        scenarios = initScenarios();
        humans = initHumans();
    }

    private Collection<HumanDao> initHumans() {
        final Collection<HumanDao> humanList;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream input = getClass().getClassLoader().getResourceAsStream("humans.json");

            humanList = objectMapper.readValue(input, new TypeReference<List<HumanDao>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // extend collection
        Collection<HumanDao> result = new ArrayList<>();
        for(HumanDao human: humanList) {
            int humanCount = human.getCount();
            for(int i = 1; i <= humanCount; i++) {
                result.add(human);
            }
        }

        return result;
    }

    private Collection<ScenarioDao> initScenarios() {
        final Collection<ScenarioDao> result;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream input = getClass().getClassLoader().getResourceAsStream("scenarios.json");

            result = objectMapper.readValue(input, new TypeReference<List<ScenarioDao>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public ScenarioDao getScenario(String name) {
        for(ScenarioDao scenario: scenarios) {
            if(scenario.getName().equals(name)) {
                return scenario;
            }
        }

        return null;
    }

    public Collection<HumanDao> getHumans() {
        return humans;
    }
}

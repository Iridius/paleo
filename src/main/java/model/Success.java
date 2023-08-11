package model;

import controller.ISuccess;

import java.util.Map;

public class Success implements ISuccess {
    private Map<String, Integer> requirements;
    private Map<String, Integer> success;

    public Success(Map<String, Integer> requirements, Map<String, Integer> success) {
        this.requirements = requirements;
        this.success = success;
    }

    @Override
    public void apply() {

    }

    @Override
    public Map<String, Integer> getRequirements() {
        return requirements;
    }

    @Override
    public Map<String, Integer> getSuccess() {
        return success;
    }
}

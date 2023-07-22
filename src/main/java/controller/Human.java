package controller;

import model.HumanDao;

import java.util.Map;

public class Human {
    private final HumanDao human;
    private int currentHealth;
    public Human(HumanDao human) {
        this.human = human;
    }
    public Map<String, Integer> getResources() {
        return human.getAbilities();
    }
}

package controller;

import model.HumanDao;

public class Human {
    private HumanDao human;
    private int currentHealth;

    public Human(HumanDao human) {
        this.human = human;
    }
}

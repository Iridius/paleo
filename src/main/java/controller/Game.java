package controller;

import model.ScenarioDao;

public class Game {
    private ScenarioDao scenario;
    private int deaths;
    private int mammoths;
    private int food;
    private int stone;
    private int wood;

    public int getDeaths() {
        return deaths;
    }

    public int getMammoths() {
        return mammoths;
    }

    public int getFood() {
        return food;
    }

    public int getStone() {
        return stone;
    }

    public int getWood() {
        return wood;
    }

    public Game(ScenarioDao scenario) {
        this.scenario = scenario;
        this.deaths = 0;
        this.mammoths = 0;
        this.food = 5;
        this.wood = 0;
        this.stone = 0;
    }
}

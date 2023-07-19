package org.example;

import controller.Game;
import model.FileModel;
import model.ScenarioDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static FileModel model;
    @BeforeAll
    public static void init() {
        model = new FileModel();
    }

    @Test
    public void check_initial_state() {
        ScenarioDao scenario = model.getScenario("Сценарий I");
        Game game = new Game(scenario);

        assertEquals(0, game.getDeaths());
        assertEquals(0, game.getMammoths());
        assertEquals(5, game.getFood());
    }
}
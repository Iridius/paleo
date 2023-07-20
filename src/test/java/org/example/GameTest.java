package org.example;

import controller.Game;
import controller.Player;
import model.FileModel;
import model.HumanDao;
import model.ScenarioDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Game game;

    @BeforeAll
    public static void init() {
        FileModel model = new FileModel();
        ScenarioDao scenario = model.getScenario("Сценарий I");
        Collection<HumanDao> humans = model.getHumans();

        Collection<Player> players = Arrays.asList(new Player(humans));
        game = new Game(scenario, players);
    }

    @Test
    public void check_initial_state() {
        assertEquals(0, game.getDeaths());
        assertEquals(0, game.getMammoths());
        assertEquals(5, game.getFood());
    }

    @Test
    public void check_initial_player() {
        assertNotNull(game.getCurrentPlayer());
    }

    @Test
    public void check_initial_humans() {
        assertEquals(2, game.getCurrentPlayer().getHumans().size());
    }
}
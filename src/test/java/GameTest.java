import controller.Game;
import controller.Player;
import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class GameTest {
    private static Game game;

    @BeforeAll
    public static void init() {
        FileModel model = new FileModel();
        ScenarioDao scenario = model.getScenario("Сценарий I");
        HumanDao humanDao = new HumanDao("Умелец", 3, new HashMap<String, Integer>() {{put("hammer", 1);}}, 3);

        Collection<Player> players = Collections.singletonList(new Player(Collections.singletonList(humanDao)));
        game = new Game(scenario, players);
    }

    @Test
    public void check_initial_state() {
        assertEquals(0, game.getResources("death"));
        assertEquals(0, game.getResources("mammoth"));
        assertEquals(5, game.getResources("food"));
    }

    @Test
    public void check_initial_player() {
        assertNotNull(game.getCurrentPlayer());
    }

    @Test
    public void check_state_humans() {
        assertEquals(1, game.getResources("hammer"));
        assertEquals(0, game.getResources("cord"));
        assertEquals(0, game.getResources("torch"));
    }

    @Test
    public void check_requirements() {
        EventDao event = TestFramework.getEvent("Змея");
        Game spy = spy(game);
        when(spy.getResources(any())).thenReturn(5);

        Collection<Map<String, Integer>> requirements = spy.checkRequirements(event);
        Map<String, Integer> actual = (Map<String, Integer>) requirements.toArray()[0];

        assertEquals(1, actual.get("remove"));
        assertEquals(1, actual.get("dream_card"));
    }
}
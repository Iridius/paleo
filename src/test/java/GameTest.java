import controller.Game;
import controller.Player;
import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Game game;

    @BeforeAll
    public static void init() {
        FileModel model = new FileModel();
        ScenarioDao scenario = model.getScenario("Сценарий I");
        Collection<HumanDao> humans = model.getHumans();
        HumanDao humanDao = new HumanDao("Умелец", 3, new HashMap<String, Integer>() {{put("hammer", 1);}}, 3);

        Collection<Player> players = Arrays.asList(new Player(Arrays.asList(humanDao)));
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
        Map<String, Integer> requirements = new HashMap() {{
            put("hammer", 1);
        }};
        Map<String, Integer> success = new HashMap() {{
           put("result", 1);
        }};
        Action action = new Action(requirements, success, null);
        EventDao event = new EventDao("а", "Тест", "", Arrays.asList(action), true);

        Map<String, Integer> actual = (Map<String, Integer>) game.checkRequirements(event).toArray()[0];

        assertTrue(actual.containsKey("result"));
        assertEquals(1, actual.get("result"));
    }
}
import controller.Game;
import controller.Player;
import model.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

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
        Map<String, Integer> requirements = new HashMap<>();
        requirements.put("hammer", 1);

        Map<String, Integer> success = new HashMap<>();
        success.put("result", 1);

        Action action = new Action(requirements, success, null);
        EventDao event = new EventDao("а", "Тест", "", Collections.singletonList(action), true);

        Map<String, Integer> actual = (Map<String, Integer>) game.checkRequirements(event).toArray()[0];

        assertTrue(actual.containsKey("result"));
        assertEquals(1, actual.get("result"));
    }
}
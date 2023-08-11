import controller.*;
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

        Collection<Player> players = Collections.singletonList(new Player(Collections.singletonList(humanDao), model.getEvents()));
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
    public void check_requirements_true() {
        EventDao event = TestFramework.getEvent("Змея");
        Game spy = spy(game);
        when(spy.getResources(any())).thenReturn(5);

        Collection<IResult> results = spy.getPossibleResults(event);
        ISuccess actual = (ISuccess) results.toArray()[0];

        assertEquals(1, actual.getSuccess().get("remove"));
        assertEquals(1, actual.getSuccess().get("dream_card"));
    }

    @Test
    public void check_requirements_false() {
        EventDao event = TestFramework.getEvent("Змея");
        Game spy = spy(game);
        when(spy.getResources(any())).thenReturn(1);

        List<IResult> results = spy.getPossibleResults(event);
        IFail actual = (IFail) results.toArray()[0];

        assertEquals(2, actual.getFail().get("damage"));
    }

    @Test
    public void check_requirements_2_true() {
        EventDao event = TestFramework.getEvent("Камнепад");
        Game spy = spy(game);
        when(spy.getResources("attention")).thenReturn(2);

        List<IResult> results = spy.getPossibleResults(event);
        ISuccess actual = (ISuccess)results.toArray()[0];

        assertEquals(2, actual.getSuccess().get("stone"));
    }

    @Test
    public void check_drop() {
        assertTrue(game.getResources("drop") > 10);
    }

    @Test
    public void check_drop_after_success() {
        EventDao event = TestFramework.getEvent("Беспомощный кабан");
        Game spy = spy(game);
        when(spy.getResources(any())).thenReturn(10);
        int before = game.getResources("drop");

        List<IResult> results = spy.getPossibleResults(event);
        for(IResult result: results) {
            assertTrue(result instanceof ISuccess);
        }
        int after = game.getResources("drop");

        assertEquals(3, before - after);
    }

    @Test
    public void apply_one_possible_success() {

    }

    @Test
    public void apply_one_fail() {

    }
}
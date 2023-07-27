package controller;

import model.EventDao;
import model.FileModel;
import model.HumanDao;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void resources_from_several_humans() {
        FileModel model = new FileModel();
        Collection<HumanDao> humans = model.getHumans();
        HumanDao human1 = new HumanDao("Умелец", 3, new HashMap<String, Integer>() {{put("hammer", 1);}}, 3);
        HumanDao human2 = new HumanDao("Умелец", 3, new HashMap<String, Integer>() {{put("hammer", 1);}}, 3);

        Collection<EventDao> events = model.getEvents();

        Player player = new Player(Arrays.asList(human1, human2), events);

        assertEquals(2, player.getResources().get("hammer"));
    }
}
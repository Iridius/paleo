package controller;

import model.EventDao;
import model.HumanDao;

import java.util.*;

public class Player {
    private List<Human> humans;
    private final Map<String, Integer> resources;

    private final Collection<EventDao> events;

    public Player(Collection<HumanDao> humans, Collection<EventDao> events) {
        Library library = new Library();

        this.humans = new ArrayList<>();
        this.humans.add(new Human(library.getRandom(humans)));
        this.humans.add(new Human(library.getRandom(humans)));

        this.resources = new HashMap<>();
        for(HumanDao human: humans) {
            for(String ability: human.getAbilities().keySet()) {
                resources.put(ability, resources.getOrDefault(ability, 0) + human.getAbilities().get(ability));
            }
        }

        this.events = events;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public Collection<EventDao> getEvents() {
        return events;
    }
}
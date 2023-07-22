package controller;

import model.HumanDao;

import java.util.*;

public class Player {
    private List<Human> humans;
    private Map<String, Integer> resources;

    public Player(Collection<HumanDao> humans) {
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
    }

    public Map<String, Integer> getResources() {
        return resources;
    }
}
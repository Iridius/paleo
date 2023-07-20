package controller;

import model.HumanDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Player {
    private List<Human> humans;

    public Player(Collection<HumanDao> humans) {
        this.humans = new ArrayList<>();
        this.humans.add(new Human(Library.getRandom(humans)));
        this.humans.add(new Human(Library.getRandom(humans)));
    }

    public List<Human> getHumans() {
        return humans;
    }
}
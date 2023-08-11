package controller;

import model.Action;
import model.EventDao;
import model.ScenarioDao;
import model.Success;

import java.util.*;

public class Game {
    private ScenarioDao scenario;
    private final Map<String, Integer> resources;
    private Player currentPlayer;

    public Game(ScenarioDao scenario, Collection<Player> players) {
        this.scenario = scenario;
        this.resources = new HashMap<>();
        this.resources.put("food", 5);

        if(players.size() > 0) {
            this.currentPlayer = (Player) players.toArray()[0];
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public int getResources(String name) {
        Map<String, Integer> buffer = new HashMap<>(currentPlayer.getResources());
        buffer.put("drop", currentPlayer.getEvents().size());
        buffer.putAll(resources);

        return buffer.getOrDefault(name, 0);
    }

    public List<IResult> getPossibleResults(EventDao event) {
        List<IResult> results = new ArrayList<>();

        int i = 0;
        for(Action action: event.getActions()) {
            boolean accepted = true;
            Map<String, Integer> requirements = action.getSuccess().getRequirements();

            for(String requirement: requirements.keySet()) {
                int hasResources = this.getResources(requirement);
                int neededResources = requirements.get(requirement);

                if(hasResources < neededResources) {
                    accepted = false;
                    break;
                }
            }

            if(accepted) {
                results.add(action.getSuccess());
            } else {
                results.add(action.getFail());
            }
            i++;
        }

        return results;
    }
}

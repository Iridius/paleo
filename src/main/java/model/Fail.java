package model;

import controller.IFail;

import java.util.Map;

public class Fail implements IFail {
    private final Map<String, Integer> fail;

    public Fail(Map<String, Integer> fail) {
        this.fail = fail;
    }

    @Override
    public Map<String, Integer> getFail() {
        return fail;
    }

    @Override
    public void apply() {

    }
}

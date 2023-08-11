package controller;

import java.util.Map;

public interface ISuccess extends IResult {
    Map<String, Integer> getRequirements();
    Map<String, Integer> getSuccess();
}

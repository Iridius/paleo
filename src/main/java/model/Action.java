package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import controller.IFail;
import controller.IResult;
import controller.ISuccess;

import java.util.Map;

public class Action {
    private final ISuccess success;
    private final IFail fail;

    @JsonCreator
    public Action(@JsonProperty("requirements") Map<String, Integer> requirements,
                  @JsonProperty("success") Map<String, Integer> success,
                  @JsonProperty("fail") Map<String, Integer> fail) {
        this.success = new Success(requirements, success);
        this.fail = new Fail(fail);
    }

    public ISuccess getSuccess() {
        return success;
    }

    public IFail getFail() {
        return fail;
    }
}

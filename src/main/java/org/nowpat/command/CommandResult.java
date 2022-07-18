package org.nowpat.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static org.nowpat.command.CommandResult.Result.FAILURE;
import static org.nowpat.command.CommandResult.Result.SUCCESS;

@Getter
@EqualsAndHashCode
public class CommandResult {

    private Result result;
    private String message;

    public CommandResult(Result result, String message) {
        this.result = result;
        this.message = message;
    }

    public boolean isSuccess() {
        return SUCCESS.equals(result);
    }

    public boolean isFailure() {
        return FAILURE.equals(result);
    }

    public boolean hasMessage() {
        return message != null;
    }

    public static CommandResult createSuccess() {
        return new CommandResult(SUCCESS, null);
    }
    public static CommandResult createSuccess(String message) {
        return new CommandResult(SUCCESS, message);
    }

    public static CommandResult createFailure() {
        return new CommandResult(FAILURE, null);
    }
    public static CommandResult createFailure(String message) {
        return new CommandResult(FAILURE, message);
    }

    public enum Result {
        SUCCESS, FAILURE
    }
}

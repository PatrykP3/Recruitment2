package org.nowpat.command.factory;

import org.nowpat.command.*;

public class CommandFactory {

    public static final int COMMAND = 0;
    public static final int NAME = 1;
    public static final int VALUE = 2;

    public static DatabaseCommand getCommand(String commandLine) throws IllegalCommandException {

        String[] commandLineData = commandLine.split(" ");

        switch(commandLineData[COMMAND]) {

            case "SET":
                return new SetCommand(commandLineData[NAME], Integer.valueOf(commandLineData[VALUE]));

            case "GET":
                return new GetCommand(commandLineData[NAME]);

            case "DELETE":
                return new DeleteCommand(commandLineData[NAME]);

            case "COUNT":
                return new CountCommand(commandLineData[NAME]);

            case "BEGIN":
                return new BeginCommand();

            case "COMMIT":
                return new CommitCommand();

            case "ROLLBACK":
                return new RollbackCommand();

            default:
                throw new IllegalCommandException("Unknown command name.");
        }
    }
}

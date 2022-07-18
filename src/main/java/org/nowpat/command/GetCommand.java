package org.nowpat.command;

import org.nowpat.database.Database;
import org.nowpat.entity.Item;

public class GetCommand implements DatabaseCommand {

    private String name;

    public GetCommand(String name) {

        this.name = name;
    }

    @Override
    public CommandResult run(Database database) {

        String result;

        if(database.getData().containsKey(name)) {

            Item item = database.getData().get(name);
            result = String.valueOf(item.getValue());
        }
        else {
            result = "NULL";
        }

        return CommandResult.createSuccess(result);
    }
}

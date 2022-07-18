package org.nowpat.command;

import org.nowpat.database.Database;
import org.nowpat.entity.Item;

public class SetCommand implements DatabaseCommand {

    private String name;
    private int value;

    public SetCommand(String name, int value) {

        this.name = name;
        this.value = value;
    }

    @Override
    public CommandResult run(Database database) {

        database.getData().put(name, new Item(name, value));

        return CommandResult.createSuccess();
    }

    @Override
    public String getItemName() {
        return name;
    }
}

package org.nowpat.command;

import org.nowpat.database.Database;
import org.nowpat.entity.Item;

public class CountCommand implements DatabaseCommand {

    private int value;

    public CountCommand(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public CommandResult run(Database database) {

        int count = 0;

        for(Item item : database.getData().values()) {
            if(item.getValue() == value) {
                count ++;
            }
        }

        return CommandResult.createSuccess(String.valueOf(count));
    }
}

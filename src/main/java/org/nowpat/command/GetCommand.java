package org.nowpat.command;

import org.nowpat.database.Database;
import org.nowpat.entity.Item;

public class GetCommand implements DatabaseCommand {

    private String name;

    public GetCommand(String name) {

        this.name = name;
    }

    @Override
    public void run(Database database) {

        if(database.getData().containsKey(name)) {

            Item item = database.getData().get(name);
            System.out.println(item.getValue());
            return;
        }

        System.out.println("NULL");
    }

    @Override
    public String getItemName() {
        return null;
    }
}

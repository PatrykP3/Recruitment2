package org.nowpat.command;

import lombok.AllArgsConstructor;
import org.nowpat.database.Database;

@AllArgsConstructor
public class DeleteCommand implements DatabaseCommand {

    private String name;

    @Override
    public void run() {

        Database.data.remove(name);
    }

    @Override
    public String getItemName() {
        return name;
    }
}

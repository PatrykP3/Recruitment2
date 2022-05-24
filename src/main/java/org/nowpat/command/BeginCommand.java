package org.nowpat.command;

import org.nowpat.database.Database;

public class BeginCommand implements DatabaseCommand {

    @Override
    public void run(Database database) {
        database.transactionStart();
    }

    @Override
    public String getItemName() {
        return null;
    }
}

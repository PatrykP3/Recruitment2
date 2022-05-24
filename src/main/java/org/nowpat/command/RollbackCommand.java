package org.nowpat.command;

import org.nowpat.database.Database;

public class RollbackCommand implements DatabaseCommand {
    @Override
    public void run(Database database) {

        database.transactionRollback();
    }

    @Override
    public String getItemName() {
        return null;
    }
}

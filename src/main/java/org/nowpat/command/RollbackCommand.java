package org.nowpat.command;

import org.nowpat.database.Database;

public class RollbackCommand implements DatabaseCommand {
    @Override
    public void run() {

        Database.transactionRollback();
    }

    @Override
    public String getItemName() {
        return null;
    }
}

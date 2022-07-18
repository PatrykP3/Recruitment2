package org.nowpat.command;

import org.nowpat.database.Database;

public class RollbackCommand implements DatabaseCommand {

    @Override
    public CommandResult run(Database database) {

        if(database.isTransactionRunning()) {
            database.transactionRollback();
            return CommandResult.createSuccess();
        }
        return CommandResult.createFailure("No transaction in progress.");
    }
}

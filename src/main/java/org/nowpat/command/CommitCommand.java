package org.nowpat.command;

import org.nowpat.database.Database;

public class CommitCommand implements DatabaseCommand {

    @Override
    public CommandResult run(Database database) {

        if(database.isTransactionRunning()) {

            database.transactionEnd();

            return CommandResult.createSuccess();
        }

        return CommandResult.createFailure("No transaction in progress.");
    }
}

package org.nowpat.command;

import org.nowpat.database.Database;

public class BeginCommand implements DatabaseCommand {

    @Override
    public CommandResult run(Database database) {
        database.transactionStart();

        return CommandResult.createSuccess();
    }
}

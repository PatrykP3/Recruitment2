package org.nowpat.command;

import org.nowpat.database.Database;

public class CommitCommand implements DatabaseCommand {

    @Override
    public void run() {
        Database.transactionEnd();
    }

    @Override
    public String getItemName() {
        return null;
    }
}

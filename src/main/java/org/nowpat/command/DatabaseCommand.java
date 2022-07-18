package org.nowpat.command;

import org.nowpat.database.Database;

public interface DatabaseCommand {

    CommandResult run(Database database);

    default String getItemName() {
        return null;
    }
}

package org.nowpat.command;

import org.nowpat.database.Database;

public interface DatabaseCommand {

    void run(Database database);
    String getItemName();
}

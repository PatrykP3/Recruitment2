package org.nowpat.command;

import org.nowpat.database.Database;

public interface DatabaseCommand {

    public void run();
    public String getItemName();
}

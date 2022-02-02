package org.nowpat.reader;

import org.nowpat.command.CommandFactory;
import org.nowpat.command.DatabaseCommand;
import org.nowpat.database.Database;

import java.util.Scanner;

public class Reader {

    public void read() {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {

            DatabaseCommand command = CommandFactory.getCommand(scanner.nextLine());
            Database.runCommand(command);
        }
    }
}

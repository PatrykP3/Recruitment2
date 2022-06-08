package org.nowpat.reader;

import org.nowpat.command.CommandFactory;
import org.nowpat.command.DatabaseCommand;
import org.nowpat.database.Database;

import java.io.InputStream;
import java.util.Scanner;

public class Reader {

    private InputStream inputStream;

    public Reader(InputStream inputStream) {

        this.inputStream = inputStream;
    }

    public void read() {
        Scanner scanner = new Scanner(inputStream);
        Database database = new Database();
        while(scanner.hasNext()) {

            DatabaseCommand command = CommandFactory.getCommand(scanner.nextLine());
            database.runCommand(command);
        }
    }
}

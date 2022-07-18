package org.nowpat.reader;

import org.nowpat.command.CommandResult;
import org.nowpat.command.DatabaseCommand;
import org.nowpat.command.factory.CommandFactory;
import org.nowpat.command.factory.IllegalCommandException;
import org.nowpat.database.Database;
import org.nowpat.printer.OutputPrinter;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class InputReader {

    private InputStream inputStream;
    private PrintWriter errorWriter;
    private OutputPrinter outputPrinter;

    public InputReader(InputStream inputStream, OutputStream errorStream, OutputPrinter outputPrinter) {

        this.inputStream = inputStream;
        this.errorWriter = new PrintWriter(errorStream, true);
        this.outputPrinter = outputPrinter;
    }

    public void read() {
        Scanner scanner = new Scanner(inputStream);
        Database database = new Database();
        while (scanner.hasNext()) {

            DatabaseCommand command;
            try {
                command = CommandFactory.getCommand(scanner.nextLine());
            }
            catch (IllegalCommandException exception) {
                errorWriter.println(exception.getLocalizedMessage());
                return;
            }

            CommandResult commandResult = database.runCommand(command);
            outputPrinter.outputResult(commandResult);
        }
    }
}

package org.nowpat.printer;

import org.nowpat.command.CommandResult;

import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputPrinter {

    private PrintWriter outputWriter;
    private PrintWriter errorWriter;

    public OutputPrinter(OutputStream outputStream, OutputStream errorStream) {
        this.outputWriter = new PrintWriter(outputStream, true);
        this.errorWriter = new PrintWriter(errorStream, true);
    }


    public void outputResult(CommandResult commandResult) {
        if (commandResult.hasMessage()) {
            switch (commandResult.getResult()) {
                case SUCCESS:
                    outputWriter.println(commandResult.getMessage());
                    break;
                case FAILURE:
                    errorWriter.println(commandResult.getMessage());
                    break;
            }
        }
    }
}

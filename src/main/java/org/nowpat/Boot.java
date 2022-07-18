package org.nowpat;

import org.nowpat.printer.OutputPrinter;
import org.nowpat.reader.InputReader;

public class Boot {

    public static void main(String[] args) {

        OutputPrinter outputPrinter = new OutputPrinter(System.out, System.err);
        InputReader reader = new InputReader(System.in, System.err, outputPrinter);
        reader.read();
    }
}

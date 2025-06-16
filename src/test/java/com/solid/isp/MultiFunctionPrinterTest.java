package com.solid.isp;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class MultiFunctionPrinterTest {
    private final MultiFunctionPrinter mfp = new MultiFunctionPrinter("TestMFP");
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Test
    void print_outputsCorrectly() {
        System.setOut(new PrintStream(outContent));
        mfp.print();
        assertTrue(outContent.toString().contains("TestMFP is printing a document."));
        System.setOut(originalOut);
    }

    @Test
    void scan_outputsCorrectly() {
        System.setOut(new PrintStream(outContent));
        mfp.scan();
        assertTrue(outContent.toString().contains("TestMFP is scanning a document."));
        System.setOut(originalOut);
    }

    @Test
    void fax_outputsCorrectly() {
        System.setOut(new PrintStream(outContent));
        mfp.fax();
        assertTrue(outContent.toString().contains("TestMFP is faxing a document."));
        System.setOut(originalOut);
    }
}

package com.solid.isp;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SimpleTextDocumentTest {
    @Test
    void print_outputsCorrectFormat() {
        SimpleTextDocument doc = new SimpleTextDocument("Test content for printing.");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        doc.print();

        assertTrue(outContent.toString().contains("Printing SimpleTextDocument: Test content for printing."));
        System.setOut(originalOut);
    }
}

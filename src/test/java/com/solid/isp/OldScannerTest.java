package com.solid.isp;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class OldScannerTest {
    @Test
    void scan_outputsCorrectly() {
        OldScanner scanner = new OldScanner("TestScanner9000");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        scanner.scan();

        assertTrue(outContent.toString().contains("TestScanner9000 (Old Scanner) is scanning."));
        System.setOut(originalOut);
    }
}

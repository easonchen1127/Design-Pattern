package com.patterns.structural.adapter;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class LegacyLogWriterTest {
    private final LegacyLogWriter legacyWriter = new LegacyLogWriter();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Test
    void writeLogEntry_formatsCorrectly() {
        System.setOut(new PrintStream(outContent));
        legacyWriter.writeLogEntry("DEBUG", "Test debug message");
        assertTrue(outContent.toString().contains("LEGACY LOG [DEBUG]: Test debug message"));
        System.setOut(originalOut);
    }

    @Test
    void writeCriticalError_formatsCorrectly() {
        System.setErr(new PrintStream(errContent));
        legacyWriter.writeCriticalError("Test critical error", 123);
        assertTrue(errContent.toString().contains("LEGACY CRITICAL ERROR [123]: Test critical error"));
        System.setErr(originalErr);
    }
}

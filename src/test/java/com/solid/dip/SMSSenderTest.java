package com.solid.dip;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SMSSenderTest {
    @Test
    void sendMessage_printsCorrectSMSFormat() {
        SMSSender smsSender = new SMSSender();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        smsSender.sendMessage("12345", "Hello SMS");

        assertTrue(outContent.toString().contains("Sending SMS to 12345: Hello SMS"));
        System.setOut(originalOut);
    }
}

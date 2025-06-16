package com.solid.dip;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class EmailSenderTest {
    @Test
    void sendMessage_printsCorrectEmailFormat() {
        EmailSender emailSender = new EmailSender();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        emailSender.sendMessage("test@example.com", "Hello Email");

        assertTrue(outContent.toString().contains("Sending EMAIL to test@example.com: Hello Email"));
        System.setOut(originalOut); // Restore System.out
    }
}

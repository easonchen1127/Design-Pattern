package com.solid.dip;

// This is a "low-level" module because it deals with specific sending details.
// It DEPENDS on the MessageSender abstraction by implementing it.
public class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String recipient, String message) {
        // In a real app, this would involve email sending logic
        System.out.println("Sending EMAIL to " + recipient + ": " + message);
    }
}

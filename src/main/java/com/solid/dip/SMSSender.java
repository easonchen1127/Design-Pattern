package com.solid.dip;

// Another "low-level" module.
// It also DEPENDS on the MessageSender abstraction.
public class SMSSender implements MessageSender {
    @Override
    public void sendMessage(String recipient, String message) {
        // In a real app, this would involve SMS gateway logic
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

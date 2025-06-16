package com.solid.dip;

// This is a "high-level" module because it defines application policy.
// It DEPENDS on the MessageSender abstraction, NOT on concrete EmailSender or SMSSender.
public class NotificationService {
    private final MessageSender messageSender; // Depends on the abstraction

    // Dependency is injected (e.g., via constructor)
    public NotificationService(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String recipient, String message) {
        if (recipient == null || recipient.trim().isEmpty() || message == null || message.trim().isEmpty()) {
            System.err.println("Recipient and message cannot be empty.");
            return;
        }
        // The NotificationService doesn't know or care if it's email or SMS.
        // It just uses the sendMessage method from the abstraction.
        this.messageSender.sendMessage(recipient, message);
    }
}

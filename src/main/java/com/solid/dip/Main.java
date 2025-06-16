package com.solid.dip;

public class Main {
    public static void main(String[] args) {
        // Create concrete sender instances (low-level details)
        MessageSender emailSender = new EmailSender();
        MessageSender smsSender = new SMSSender();

        // --- Using Email ---
        // Inject the EmailSender dependency into the NotificationService
        NotificationService emailNotificationService = new NotificationService(emailSender);
        System.out.println("--- Email Notifications ---");
        emailNotificationService.sendNotification("john.doe@example.com", "Your order has shipped!");
        emailNotificationService.sendNotification("jane.doe@example.com", "Meeting reminder at 2 PM.");

        System.out.println();

        // --- Using SMS ---
        // Inject the SMSSender dependency into a new NotificationService instance
        NotificationService smsNotificationService = new NotificationService(smsSender);
        System.out.println("--- SMS Notifications ---");
        smsNotificationService.sendNotification("+1234567890", "Your package is out for delivery.");
        smsNotificationService.sendNotification("+0987654321", "Alert: System maintenance upcoming.");

        // The NotificationService code itself didn't change,
        // only the concrete MessageSender implementation passed to it.
        // This demonstrates DIP.
    }
}

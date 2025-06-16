package com.solid.dip;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // To enable @Mock annotation
class NotificationServiceTest {

    @Mock // Mocking the abstraction
    private MessageSender mockMessageSender;

    @Test
    void sendNotification_callsMessageSenderWithMessage() {
        // Arrange
        NotificationService notificationService = new NotificationService(mockMessageSender);
        String recipient = "user@example.com";
        String message = "Test notification";

        // Act
        notificationService.sendNotification(recipient, message);

        // Assert
        // Verify that the sendMessage method on our mock was called exactly once
        // with the correct recipient and message.
        verify(mockMessageSender, times(1)).sendMessage(recipient, message);
    }

    @Test
    void sendNotification_withNullRecipient_doesNotCallMessageSender() {
        NotificationService notificationService = new NotificationService(mockMessageSender);
        notificationService.sendNotification(null, "Test message");
        verifyNoInteractions(mockMessageSender); // Ensure sender wasn't called
    }

    @Test
    void sendNotification_withEmptyMessage_doesNotCallMessageSender() {
        NotificationService notificationService = new NotificationService(mockMessageSender);
        notificationService.sendNotification("user@example.com", " ");
        verifyNoInteractions(mockMessageSender);
    }
}

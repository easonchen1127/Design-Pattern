package com.patterns.structural.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogAdapterTest {

    @Mock
    private LegacyLogWriter mockLegacyWriter; // Mock the Adapter

    private LogAdapter adapter;

    @BeforeEach
    void setUp() {
        adapter = new LogAdapter(mockLegacyWriter);
    }

    @Test
    void constructor_nullLegacyWriter_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new LogAdapter(null));
    }

    @Test
    void logInfo_callsLegacyWriteLogEntryWithInfo() {
        String message = "Information message";
        adapter.logInfo(message);
        verify(mockLegacyWriter, times(1)).writeLogEntry("INFO", message);
    }

    @Test
    void logWarning_callsLegacyWriteLogEntryWithWarn() {
        String message = "Warning message";
        adapter.logWarning(message);
        verify(mockLegacyWriter, times(1)).writeLogEntry("WARN", message);
    }

    @Test
    void logError_withNullException_callsLegacyWriteCriticalError() {
        String message = "Error occurred";
        adapter.logError(message, null);
        verify(mockLegacyWriter, times(1)).writeCriticalError(message, 99);
    }

    @Test
    void logError_withException_callsLegacyWriteCriticalErrorWithDetails() {
        String message = "Error with exception";
        Exception ex = new RuntimeException("Specific failure");
        String expectedLegacyMessage = message + " - Details: " + ex.getMessage();

        adapter.logError(message, ex);

        verify(mockLegacyWriter, times(1)).writeCriticalError(expectedLegacyMessage, 99);
    }
}

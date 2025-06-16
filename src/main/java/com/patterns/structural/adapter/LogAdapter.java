package com.patterns.structural.adapter;

// Adapter: Adapts the interface of Adaptee to the Target interface.
// This is an Object Adapter (uses composition).
public class LogAdapter implements Logger {
    private final LegacyLogWriter legacyLogWriter; // Adaptee instance

    public LogAdapter(LegacyLogWriter legacyLogWriter) {
        if (legacyLogWriter == null) {
            throw new IllegalArgumentException("LegacyLogWriter cannot be null.");
        }
        this.legacyLogWriter = legacyLogWriter;
        System.out.println("LogAdapter created for LegacyLogWriter.");
    }

    @Override
    public void logInfo(String message) {
        legacyLogWriter.writeLogEntry("INFO", message);
    }

    @Override
    public void logWarning(String message) {
        legacyLogWriter.writeLogEntry("WARN", message);
    }

    @Override
    public void logError(String message, Exception error) {
        String errorMessage = message;
        if (error != null) {
            errorMessage += " - Details: " + error.getMessage();
        }
        // Legacy system has a specific error code method, let's use a generic code
        legacyLogWriter.writeCriticalError(errorMessage, 99); // Arbitrary error code
    }
}

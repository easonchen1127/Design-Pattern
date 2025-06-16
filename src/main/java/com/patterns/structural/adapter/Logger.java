package com.patterns.structural.adapter;

// Target Interface: Defines the domain-specific interface that Client uses.
public interface Logger {
    void logInfo(String message);
    void logWarning(String message);
    void logError(String message, Exception error);
}

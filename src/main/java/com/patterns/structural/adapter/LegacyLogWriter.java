package com.patterns.structural.adapter;

// Adapter: Defines an existing interface that needs adapting.
// This is the class we want to use, but its interface is not what the client expects.
public class LegacyLogWriter {
    public void writeLogEntry(String entryType, String text) {
        System.out.println("LEGACY LOG [" + entryType.toUpperCase() + "]: " + text);
    }

    public void writeCriticalError(String text, int errorCode) {
        System.err.println("LEGACY CRITICAL ERROR [" + errorCode + "]: " + text);
    }
}

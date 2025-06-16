package com.patterns.structural.adapter;

// Client: Collaborates with objects conforming to the Target interface.
public class ApplicationLogService {
    private Logger logger;

    // The logger can be set at runtime, allowing different logging implementations.
    public ApplicationLogService(Logger logger) {
        if (logger == null) {
            throw new IllegalArgumentException("Logger cannot be null.");
        }
        this.logger = logger;
        System.out.println("ApplicationLogService configured with a Logger.");
    }

    public void doSomethingAndLog() {
        logger.logInfo("Application performing an informational action.");
        // ... some operation ...
        if (Math.random() < 0.1) { // Simulate an error condition
            logger.logError("A simulated error occurred during processing.", new RuntimeException("Simulated failure"));
        } else {
            logger.logWarning("A potential issue was detected, but operation continued.");
        }
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}

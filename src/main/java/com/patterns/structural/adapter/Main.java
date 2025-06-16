package com.patterns.structural.adapter;

// Standard Logger implementation (not using legacy for comparison)
class StandardLogger implements Logger {
    @Override
    public void logInfo(String message) { System.out.println("STANDARD INFO: " + message); }
    @Override
    public void logWarning(String message) { System.out.println("STANDARD WARN: " + message); }
    @Override
    public void logError(String message, Exception error) { System.err.println("STANDARD ERROR: " + message + (error != null ? " - " + error.getMessage() : "")); }
}


public class Main {
    public static void main(String[] args) {
        System.out.println("--- Using Standard Logger ---");
        Logger standardLogger = new StandardLogger();
        ApplicationLogService appService1 = new ApplicationLogService(standardLogger);
        appService1.doSomethingAndLog();

        System.out.println("\n--- Using Legacy Logger via Adapter ---");
        LegacyLogWriter legacyWriter = new LegacyLogWriter();
        Logger adaptedLegacyLogger = new LogAdapter(legacyWriter); // Wrap legacy logger with adapter
        ApplicationLogService appService2 = new ApplicationLogService(adaptedLegacyLogger);
        appService2.doSomethingAndLog();

        System.out.println("\n--- Another action with the adapted logger ---");
        adaptedLegacyLogger.logInfo("System startup complete.");
        adaptedLegacyLogger.logWarning("Low disk space warning.");
        adaptedLegacyLogger.logError("Critical component failed.", new IllegalStateException("Component X unresponsive"));

        // The ApplicationLogService doesn't know it's using a legacy system,
        // it only interacts with the Logger interface.
    }
}

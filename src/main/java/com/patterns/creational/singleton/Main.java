package com.patterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Accessing ConfigurationManager (Singleton) ---");

        // Get the singleton instance
        ConfigurationManager configManager1 = ConfigurationManager.getInstance();
        ConfigurationManager configManager2 = ConfigurationManager.getInstance();

        // Verify that both references point to the same object
        System.out.println("configManager1 == configManager2: " + (configManager1 == configManager2)); // Should be true

        System.out.println("\nInitial settings from configManager1:");
        System.out.println("DB URL: " + configManager1.getSetting("db.url"));
        System.out.println("API Timeout: " + configManager1.getSetting("api.timeout"));

        // Modify a setting using one instance
        System.out.println("\nModifying 'api.timeout' using configManager1...");
        configManager1.setSetting("api.timeout", "10000");
        configManager1.setSetting("app.theme", "dark");

        // Access the modified setting using the other instance
        System.out.println("\nSettings from configManager2 (should reflect changes):");
        System.out.println("DB URL: " + configManager2.getSetting("db.url")); // Unchanged
        System.out.println("API Timeout: " + configManager2.getSetting("api.timeout")); // Should be 10000
        System.out.println("App Theme: " + configManager2.getSetting("app.theme"));   // Should be dark

        System.out.println("\nAll settings from configManager1:");
        configManager1.printSettings();


        // Attempting to create instance via constructor (should fail if truly private, but this code wouldn't compile)
        // ConfigurationManager newInstance = new ConfigurationManager(); // COMPILE ERROR: Constructor is private

        // Attempting to clone (should throw CloneNotSupportedException)
        try {
            ConfigurationManager clonedManager = (ConfigurationManager) configManager1.clone();
            System.out.println("Cloned instance: " + clonedManager); // Should not reach here
        } catch (CloneNotSupportedException e) {
            System.err.println("Cloning attempt failed as expected: " + e.getMessage());
        }


        // Simulating multi-threaded access (basic test)
        System.out.println("\n--- Simulating Multi-threaded Access ---");
        Runnable task = () -> {
            ConfigurationManager threadInstance = ConfigurationManager.getInstance();
            System.out.println(Thread.currentThread().getName() + " got instance: " + System.identityHashCode(threadInstance) +
                    ", API Timeout: " + threadInstance.getSetting("api.timeout"));
            threadInstance.setSetting("thread.specific.value", Thread.currentThread().getName());
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread finishing multi-thread simulation.");
        configManager1.printSettings(); // Check settings after threads
    }
}

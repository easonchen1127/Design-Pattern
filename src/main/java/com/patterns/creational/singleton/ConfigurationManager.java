package com.patterns.creational.singleton;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConfigurationManager {

    private Map<String, String> settings;
    private final Lock settingsLock = new ReentrantLock(); // For thread-safe modifications if needed

    // 1. Private constructor to prevent instantiation from outside
    private ConfigurationManager() {
        settings = new HashMap<>();
        // Simulate loading initial configuration
        System.out.println("ConfigurationManager: Initializing and loading default settings...");
        settings.put("db.url", "jdbc:default:db");
        settings.put("api.timeout", "5000");
        System.out.println("ConfigurationManager: Instance created.");
    }

    // 2. Private static inner helper class to hold the instance (Bill Pugh Singleton)
    // This ensures lazy initialization in a thread-safe manner without explicit synchronization
    // in the getInstance() method. The class is loaded only when getInstance() is called.
    private static class SingletonHelper {
        private static ConfigurationManager INSTANCE = new ConfigurationManager();
    }

    // 3. Public static method to get the single instance
    public static ConfigurationManager getInstance() {
        return SingletonHelper.INSTANCE;
    }

    // Add a package-private static method for testing to reset the instance
    static void resetInstanceForTesting() {
        System.out.println("ConfigurationManager: Resetting instance for testing.");
        SingletonHelper.INSTANCE = new ConfigurationManager();
    }

    // Business methods
    public String getSetting(String key) {
        settingsLock.lock(); // Not strictly necessary for read if using ConcurrentHashMap or if map is effectively immutable after load
        try {
            return settings.get(key);
        } finally {
            settingsLock.unlock();
        }
    }

    public void setSetting(String key, String value) {
        settingsLock.lock();
        try {
            System.out.println("ConfigurationManager: Setting '" + key + "' to '" + value + "'");
            settings.put(key, value);
        } finally {
            settingsLock.unlock();
        }
    }

    public Map<String, String> getAllSettings() {
        settingsLock.lock();
        try {
            // Return an unmodifiable copy to prevent external modification of the internal map
            return Collections.unmodifiableMap(new HashMap<>(settings));
        } finally {
            settingsLock.unlock();
        }
    }

    // Prevent cloning of the singleton instance (optional but good practice)
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton cannot be cloned.");
    }

    // Prevent deserialization from creating new instances (optional but good practice for robust singletons)
    // This requires the class to be Serializable, which might not always be desired.
    // If not serializable, this method is not needed.
    /*
    protected Object readResolve() {
        return getInstance();
    }
    */

    public void printSettings() {
        System.out.println("Current Configuration Settings:");
        getAllSettings().forEach((key, value) -> System.out.println("  " + key + " = " + value));
    }
}

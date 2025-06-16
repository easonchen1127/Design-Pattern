package com.patterns.creational.singleton;

import com.patterns.creational.singleton.ConfigurationManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationManagerTest {

    @BeforeEach
    void resetSingleton() {
        // Call the package-private reset method
        ConfigurationManager.resetInstanceForTesting();
    }



    @Test
    void getInstance_shouldReturnSameInstance() {
        ConfigurationManager instance1 = ConfigurationManager.getInstance();
        ConfigurationManager instance2 = ConfigurationManager.getInstance();

        assertNotNull(instance1, "Instance 1 should not be null.");
        assertNotNull(instance2, "Instance 2 should not be null.");
        assertSame(instance1, instance2, "getInstance() should always return the same instance.");
    }

    @Test
    void getSetting_shouldReturnDefaultValue() {
        ConfigurationManager config = ConfigurationManager.getInstance();
        // Assuming resetSingleton() ensures a fresh load or the test order allows this check
        assertEquals("jdbc:default:db", config.getSetting("db.url"));
        assertEquals("5000", config.getSetting("api.timeout")); // This might fail if a previous test changed it and reset is not perfect
    }

    @Test
    void setAndGetSetting_shouldStoreAndRetrieveValue() {
        ConfigurationManager config = ConfigurationManager.getInstance();
        String key = "new.setting";
        String value = "new.value";

        config.setSetting(key, value);
        assertEquals(value, config.getSetting(key));
    }

    @Test
    void getAllSettings_shouldReturnUnmodifiableMap() {
        ConfigurationManager config = ConfigurationManager.getInstance();
        config.setSetting("test.key", "test.value"); // Add a setting

        Map<String, String> settings = config.getAllSettings();
        assertNotNull(settings);
        assertEquals("test.value", settings.get("test.key"));

        // Attempting to modify the returned map should throw an exception
        assertThrows(UnsupportedOperationException.class, () -> {
            settings.put("another.key", "another.value");
        }, "Returned map from getAllSettings should be unmodifiable.");
    }

    @Test
    void clone_shouldThrowCloneNotSupportedException() {
        ConfigurationManager instance = ConfigurationManager.getInstance();
        assertThrows(CloneNotSupportedException.class, () -> {
            instance.clone();
        }, "Cloning a Singleton instance should not be supported.");
    }

    // Test for reflection-based instantiation (to show why private constructor is important)
    @Test
    void constructor_isPrivateAndPreventsDirectInstantiation() {
        Constructor<?>[] constructors = ConfigurationManager.class.getDeclaredConstructors();
        assertEquals(1, constructors.length, "Should only have one constructor (the private one).");
        assertTrue(java.lang.reflect.Modifier.isPrivate(constructors[0].getModifiers()),
                "Constructor should be private.");

        // Attempt to create instance via reflection (simulating malicious attempt)
        // This test itself doesn't prevent it, but verifies the constructor is private.
        // A more robust singleton might add checks in the constructor itself.
        try {
            constructors[0].setAccessible(true); // Make it accessible for test
            ConfigurationManager instance1 = (ConfigurationManager) constructors[0].newInstance();
            ConfigurationManager instance2 = (ConfigurationManager) constructors[0].newInstance();
            assertNotSame(instance1, instance2, "Reflection instantiation should create different objects if constructor is called directly.");
            constructors[0].setAccessible(false); // Reset
        } catch (Exception e) {
            fail("Reflection test failed: " + e.getMessage());
        }
    }
}

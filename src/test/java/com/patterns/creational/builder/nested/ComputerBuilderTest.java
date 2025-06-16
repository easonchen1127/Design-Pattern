package com.patterns.creational.builder.nested;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerBuilderTest {

    @Test
    void build_withOnlyRequiredFields_shouldCreateComputer() {
        Computer computer = new Computer.Builder("AMD Ryzen 5", "16GB DDR4").build();
        assertNotNull(computer);
        assertEquals("AMD Ryzen 5", computer.getCpu());
        assertEquals("16GB DDR4", computer.getRam());
        assertNull(computer.getStorage(), "Storage should be null if not set");
        assertNull(computer.getGraphicsCard(), "Graphics Card should be null if not set");
        assertNull(computer.getOperatingSystem(), "OS should be null if not set");
    }

    @Test
    void build_withAllFields_shouldCreateComputerWithAllSpecs() {
        String cpu = "Intel Core i7";
        String ram = "32GB DDR5";
        String storage = "1TB NVMe SSD";
        String graphicsCard = "AMD RX 7800XT";
        String os = "Ubuntu 22.04";

        Computer computer = new Computer.Builder(cpu, ram)
                .storage(storage)
                .graphicsCard(graphicsCard)
                .operatingSystem(os)
                .build();

        assertNotNull(computer);
        assertEquals(cpu, computer.getCpu());
        assertEquals(ram, computer.getRam());
        assertEquals(storage, computer.getStorage());
        assertEquals(graphicsCard, computer.getGraphicsCard());
        assertEquals(os, computer.getOperatingSystem());
    }

    @Test
    void build_withSomeOptionalFields_shouldSetThemCorrectly() {
        Computer computer = new Computer.Builder("Intel Pentium", "8GB DDR3")
                .storage("256GB SSD")
                .build(); // Graphics card and OS are null

        assertNotNull(computer);
        assertEquals("Intel Pentium", computer.getCpu());
        assertEquals("8GB DDR3", computer.getRam());
        assertEquals("256GB SSD", computer.getStorage());
        assertNull(computer.getGraphicsCard());
        assertNull(computer.getOperatingSystem());
    }

    @Test
    void builderConstructor_withNullCpu_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder(null, "16GB");
        });
        assertEquals("CPU and RAM are required and cannot be empty.", exception.getMessage());
    }

    @Test
    void builderConstructor_withEmptyRam_shouldThrowIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Computer.Builder("Intel i3", "");
        });
        assertEquals("CPU and RAM are required and cannot be empty.", exception.getMessage());
    }

    @Test
    void toString_shouldReflectComputerSpecifications() {
        Computer computer = new Computer.Builder("Test CPU", "Test RAM")
                .storage("Test Storage")
                .operatingSystem("Test OS")
                .build();
        String specs = computer.toString();
        assertTrue(specs.contains("CPU: Test CPU"));
        assertTrue(specs.contains("RAM: Test RAM"));
        assertTrue(specs.contains("Storage: Test Storage"));
        assertTrue(specs.contains("OS: Test OS"));
        assertFalse(specs.contains("Graphics Card:"), "Graphics Card was not set, should not be in toString");
    }
}

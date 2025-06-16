package com.patterns.creational.builder.gof;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GamingPCBuilderTest {
    private GamingPCBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new GamingPCBuilder(); // reset() is called in constructor
    }

    @Test
    void buildCpu_setsCpu() {
        builder.buildCpu("Test CPU");
        Computer computer = builder.getResult();
        assertEquals("Test CPU", computer.getCpu());
    }

    @Test
    void buildCpu_withNull_setsDefault() {
        builder.buildCpu(null);
        Computer computer = builder.getResult();
        assertEquals("High-end Intel/AMD CPU", computer.getCpu());
    }

    @Test
    void buildRam_setsRam() {
        builder.buildRam("Test RAM");
        Computer computer = builder.getResult();
        assertEquals("Test RAM", computer.getRam());
    }

    @Test
    void buildAllParts_createsCompleteComputer() {
        builder.buildCpu("Intel i9");
        builder.buildRam("64GB");
        builder.buildStorage("2TB SSD");
        builder.buildGraphicsCard("RTX 4090");
        builder.buildOperatingSystem("Windows 11");
        Computer computer = builder.getResult();

        assertEquals("Intel i9", computer.getCpu());
        assertEquals("64GB", computer.getRam());
        assertEquals("2TB SSD", computer.getStorage());
        assertEquals("RTX 4090", computer.getGraphicsCard());
        assertEquals("Windows 11", computer.getOperatingSystem());
    }

    @Test
    void reset_createsNewComputerInstance() {
        builder.buildCpu("CPU 1");
        Computer computer1 = builder.getResult();

        builder.reset(); // Explicitly reset or rely on constructor for new builder instance
        builder.buildCpu("CPU 2");
        Computer computer2 = builder.getResult();

        assertNotSame(computer1, computer2);
        assertEquals("CPU 2", computer2.getCpu());
        assertNull(computer1.getOperatingSystem()); // Assuming reset clears all fields
    }

    @Test
    void getResult_returnsConstructedComputer() {
        builder.buildCpu("Final CPU");
        Computer computer = builder.getResult();
        assertNotNull(computer);
        assertEquals("Final CPU", computer.getCpu());
    }
}

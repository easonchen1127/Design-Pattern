package com.patterns.creational.builder.gof;

// Abstract Builder
public interface ComputerBuilder {
    void buildCpu(String cpu);
    void buildRam(String ram);
    void buildStorage(String storage);
    void buildGraphicsCard(String graphicsCard);
    void buildOperatingSystem(String os);
    Computer getResult(); // Method to retrieve the built Computer
    void reset();         // Optional: to reuse the builder for multiple Computer objects
}

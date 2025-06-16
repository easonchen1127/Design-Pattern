package com.patterns.creational.builder.nested;

public class Computer {
    // Required parameters
    private final String cpu;
    private final String ram;

    // Optional parameters
    private final String storage;
    private final String graphicsCard;
    private final String operatingSystem;

    // Private constructor to be called by the Builder
    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.operatingSystem = builder.operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer Specs: \n" +
                "  CPU: " + cpu + "\n" +
                "  RAM: " + ram + "\n" +
                (storage != null ? "  Storage: " + storage + "\n" : "") +
                (graphicsCard != null ? "  Graphics Card: " + graphicsCard + "\n" : "") +
                (operatingSystem != null ? "  OS: " + operatingSystem + "\n" : "");
    }

    // Getters for individual components (optional, for testing or use)
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getOperatingSystem() { return operatingSystem; }


    // Static nested Builder class
    public static class Builder {
        // Required parameters mirror the outer class
        private final String cpu;
        private final String ram;

        // Optional parameters initialized to default values (or null)
        private String storage = null;
        private String graphicsCard = null;
        private String operatingSystem = null;

        public Builder(String cpu, String ram) {
            if (cpu == null || ram == null || cpu.trim().isEmpty() || ram.trim().isEmpty()) {
                throw new IllegalArgumentException("CPU and RAM are required and cannot be empty.");
            }
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this; // Return builder for fluent interface
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder operatingSystem(String operatingSystem) {
            this.operatingSystem = operatingSystem;
            return this;
        }

        // The build method that returns the fully constructed Computer object
        public Computer build() {
            // Can add validation here before creating the object if needed
            return new Computer(this);
        }
    }
}

package com.patterns.creational.builder.gof;

// Product
public class Computer {
    // Components can be set by builders
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;
    private String operatingSystem;

    // Package-private constructor - only builders in the same package can access directly
    // Or could be public if builders are in different packages.
    Computer() {}

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer Specs (GoF Builder): \n" +
                "  CPU: " + (cpu != null ? cpu : "N/A") + "\n" +
                "  RAM: " + (ram != null ? ram : "N/A") + "\n" +
                (storage != null ? "  Storage: " + storage + "\n" : "") +
                (graphicsCard != null ? "  Graphics Card: " + graphicsCard + "\n" : "") +
                (operatingSystem != null ? "  OS: " + operatingSystem + "\n" : "");
    }

    // Getters for testing or use
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getOperatingSystem() { return operatingSystem; }
}

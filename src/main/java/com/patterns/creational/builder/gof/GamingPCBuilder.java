package com.patterns.creational.builder.gof;

// Concrete Builder for Gaming PCs
public class GamingPCBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingPCBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.computer = new Computer(); // Create a new Computer instance
    }

    @Override
    public void buildCpu(String cpu) {
        computer.setCpu(cpu != null ? cpu : "High-end Intel/AMD CPU");
    }

    @Override
    public void buildRam(String ram) {
        computer.setRam(ram != null ? ram : "32GB DDR5");
    }

    @Override
    public void buildStorage(String storage) {
        computer.setStorage(storage != null ? storage : "1TB NVMe SSD + 2TB HDD");
    }

    @Override
    public void buildGraphicsCard(String graphicsCard) {
        computer.setGraphicsCard(graphicsCard != null ? graphicsCard : "NVIDIA RTX 4080/4090 or AMD RX 7900XTX");
    }

    @Override
    public void buildOperatingSystem(String os) {
        computer.setOperatingSystem(os != null ? os : "Windows 11 Pro");
    }

    @Override
    public Computer getResult() {
        Computer builtComputer = this.computer;
        // Optionally reset the builder for next use, or client can call reset()
        // this.reset();
        return builtComputer;
    }
}

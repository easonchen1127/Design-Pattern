package com.patterns.creational.builder.gof;

// Concrete Builder for Office PCs
public class OfficePCBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficePCBuilder() {
        this.reset();
    }

    @Override
    public void reset() {
        this.computer = new Computer();
    }

    @Override
    public void buildCpu(String cpu) {
        computer.setCpu(cpu != null ? cpu : "Mid-range Intel Core i5/i7 or AMD Ryzen 5/7");
    }

    @Override
    public void buildRam(String ram) {
        computer.setRam(ram != null ? ram : "16GB DDR4");
    }

    @Override
    public void buildStorage(String storage) {
        computer.setStorage(storage != null ? storage : "512GB SSD");
    }

    @Override
    public void buildGraphicsCard(String graphicsCard) {
        // Office PCs often use integrated graphics, so this might be left null
        // or set to "Integrated Graphics" explicitly if desired.
        if (graphicsCard != null && !graphicsCard.isEmpty()) {
            computer.setGraphicsCard(graphicsCard);
        } else {
            computer.setGraphicsCard("Integrated Graphics");
        }
    }

    @Override
    public void buildOperatingSystem(String os) {
        computer.setOperatingSystem(os != null ? os : "Windows 11 Home/Pro");
    }

    @Override
    public Computer getResult() {
        Computer builtComputer = this.computer;
        // this.reset(); // Optional: reset after getting result
        return builtComputer;
    }
}

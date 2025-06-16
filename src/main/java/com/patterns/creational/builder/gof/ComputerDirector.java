package com.patterns.creational.builder.gof;

// Director - orchestrates the build process using a builder
public class ComputerDirector {
    private ComputerBuilder builder;

    public void setBuilder(ComputerBuilder builder) {
        this.builder = builder;
    }

    // Example construction sequence for a "Standard Gaming PC"
    public Computer constructGamingPC() {
        if (builder == null) throw new IllegalStateException("Builder not set for Director");
        builder.reset(); // Start fresh
        builder.buildCpu("Intel Core i9 Extreme"); // Director can specify some parts
        builder.buildRam("64GB DDR5 RGB");
        builder.buildStorage("2TB NVMe Gen5 SSD");
        builder.buildGraphicsCard("NVIDIA RTX Titan NextGen");
        builder.buildOperatingSystem("Windows 11 Ultimate Gamer Edition");
        return builder.getResult();
    }

    // Example construction sequence for a "Standard Office PC"
    public Computer constructOfficePC() {
        if (builder == null) throw new IllegalStateException("Builder not set for Director");
        builder.reset();
        builder.buildCpu("Intel Core i5 Standard");
        builder.buildRam("16GB DDR4 Reliable");
        builder.buildStorage("1TB SATA SSD FastBoot");
        // No dedicated graphics card specified by director, builder might set a default
        builder.buildGraphicsCard(null); // or builder.buildGraphicsCard("Integrated");
        builder.buildOperatingSystem("Windows 11 Business");
        return builder.getResult();
    }

    // Client can also use the builder directly for custom configurations
    public Computer constructCustomPC(String cpu, String ram, String storage, String gpu, String os) {
        if (builder == null) throw new IllegalStateException("Builder not set for Director");
        builder.reset();
        if (cpu != null) builder.buildCpu(cpu);
        if (ram != null) builder.buildRam(ram);
        if (storage != null) builder.buildStorage(storage);
        if (gpu != null) builder.buildGraphicsCard(gpu);
        if (os != null) builder.buildOperatingSystem(os);
        return builder.getResult();
    }
}

package com.patterns.creational.builder.nested;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Building a Gaming PC ---");
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB DDR5")
                .storage("2TB NVMe SSD")
                .graphicsCard("NVIDIA RTX 4090")
                .operatingSystem("Windows 11 Pro")
                .build();
        System.out.println(gamingPC);

        System.out.println("--- Building an Office PC (minimal specs) ---");
        Computer officePC = new Computer.Builder("Intel i5", "16GB DDR4")
                .storage("512GB SATA SSD")
                // No dedicated graphics card
                .operatingSystem("Windows 11 Home")
                .build();
        System.out.println(officePC);

        System.out.println("\n--- Building a Basic Server (only required parts) ---");
        Computer server = new Computer.Builder("AMD EPYC", "64GB ECC DDR5").build();
        System.out.println(server);

        System.out.println("\n--- Attempting to build with missing required parts (handled by Builder constructor) ---");
        try {
            Computer invalidPC = new Computer.Builder(null, "8GB").build();
            System.out.println(invalidPC); // Should not reach here
        } catch (IllegalArgumentException e) {
            System.err.println("Error building PC: " + e.getMessage());
        }

        try {
            Computer invalidPC2 = new Computer.Builder("Intel Celeron", "").build();
            System.out.println(invalidPC2); // Should not reach here
        } catch (IllegalArgumentException e) {
            System.err.println("Error building PC: " + e.getMessage());
        }
    }
}

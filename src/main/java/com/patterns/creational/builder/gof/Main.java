package com.patterns.creational.builder.gof;

public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();

        // Build a Gaming PC using GamingPCBuilder via Director
        System.out.println("--- Building Gaming PC (Director with GamingPCBuilder) ---");
        ComputerBuilder gamingBuilder = new GamingPCBuilder();
        director.setBuilder(gamingBuilder);
        Computer gamingPC = director.constructGamingPC();
        System.out.println(gamingPC);

        gamingBuilder.reset(); // Resetting builder for another potential build directly
        gamingBuilder.buildCpu("AMD Ryzen 9 Custom");
        gamingBuilder.buildRam("32GB Corsair Vengeance");
        // ... other parts for a direct build
        Computer customGamingPC = gamingBuilder.getResult();
        System.out.println("--- Building Custom Gaming PC (GamingPCBuilder directly) ---");
        System.out.println(customGamingPC);


        // Build an Office PC using OfficePCBuilder via Director
        System.out.println("\n--- Building Office PC (Director with OfficePCBuilder) ---");
        ComputerBuilder officeBuilder = new OfficePCBuilder();
        director.setBuilder(officeBuilder);
        Computer officePC = director.constructOfficePC();
        System.out.println(officePC);


        // Build a custom PC using OfficePCBuilder directly (client acts as director)
        System.out.println("\n--- Building Custom Barebones Office PC (OfficePCBuilder directly) ---");
        OfficePCBuilder customOfficeBuilder = new OfficePCBuilder(); // Using concrete type for direct calls
        customOfficeBuilder.buildCpu("Intel Celeron");
        customOfficeBuilder.buildRam("8GB DDR4");
        // Storage, GPU, OS will use defaults from OfficePCBuilder or be null
        Computer barebonesOfficePC = customOfficeBuilder.getResult();
        System.out.println(barebonesOfficePC);

        System.out.println("\n--- Building Custom PC via Director's custom method ---");
        director.setBuilder(gamingBuilder); // Re-use gaming builder for custom construction
        Computer customViaDirector = director.constructCustomPC(
                "Custom CPU X", "Custom RAM Y", null, "Custom GPU Z", "Linux Custom"
        );
        System.out.println(customViaDirector);
    }
}

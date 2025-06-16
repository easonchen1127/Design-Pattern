package com.patterns.creational.abstractfactory;

public class Main {

    private static GUIFactory configureFactory() {
        // In a real application, this might come from a config file or OS detection
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println("Operating System detected: " + osName);

        if (osName.contains("mac")) {
            System.out.println("Using macOS GUI Factory.");
            return new MacOSGUIFactory();
        } else if (osName.contains("win")) {
            System.out.println("Using Windows GUI Factory.");
            return new WindowsGUIFactory();
        } else {
            // Default or other OS
            System.out.println("OS not specifically supported for GUI, defaulting to Windows style.");
            return new WindowsGUIFactory(); // Or throw an exception, or have a generic factory
        }
    }

    public static void main(String[] args) {
        GUIFactory factory = configureFactory();

        Application app = new Application(factory);
        app.run();

        System.out.println("\n--- Simulating User Interaction ---");
        app.simulateButtonClick("Login Attempt");
        app.simulateTextFieldInput("Username123");

        // If we change the factory (e.g., by changing OS detection),
        // the Application class doesn't change, but it will get a different family of UI elements.
        // For example, if configureFactory() returned new MacOSGUIFactory():
        // GUIFactory macFactory = new MacOSGUIFactory();
        // Application macApp = new Application(macFactory);
        // macApp.run();
    }
}

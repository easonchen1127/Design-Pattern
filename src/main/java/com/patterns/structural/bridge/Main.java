package com.patterns.structural.bridge;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Controlling TV with Basic Remote ---");
        Device tv = new TV();
        RemoteControl basicRemoteForTV = new BasicRemote(tv);
        basicRemoteForTV.togglePower(); // ON
        basicRemoteForTV.volumeUp();
        basicRemoteForTV.channelUp();
        basicRemoteForTV.displayStatus();
        basicRemoteForTV.togglePower(); // OFF
        basicRemoteForTV.displayStatus();

        System.out.println("\n--- Controlling Radio with Basic Remote ---");
        Device radio = new Radio();
        RemoteControl basicRemoteForRadio = new BasicRemote(radio);
        basicRemoteForRadio.togglePower(); // ON
        basicRemoteForRadio.volumeDown();
        basicRemoteForRadio.channelDown(); // Changes frequency
        basicRemoteForRadio.displayStatus();

        System.out.println("\n--- Controlling TV with Advanced Remote ---");
        // We can use the same tv instance with a different remote abstraction
        RemoteControl advancedRemoteForTV = new AdvancedRemote(tv); // TV is currently OFF
        advancedRemoteForTV.togglePower(); // ON
        ((AdvancedRemote) advancedRemoteForTV).mute(); // Cast to use AdvancedRemote specific method
        advancedRemoteForTV.displayStatus();
        ((AdvancedRemote) advancedRemoteForTV).setFavoriteChannel(101);
        advancedRemoteForTV.displayStatus();

        System.out.println("\n--- Controlling Radio with Advanced Remote ---");
        // We can use the same radio instance with an advanced remote
        RemoteControl advancedRemoteForRadio = new AdvancedRemote(radio); // Radio is currently ON
        advancedRemoteForRadio.volumeUp();
        ((AdvancedRemote) advancedRemoteForRadio).setFavoriteChannel(102); // Sets frequency
        advancedRemoteForRadio.displayStatus();
        advancedRemoteForRadio.togglePower(); // OFF
        advancedRemoteForRadio.displayStatus();
    }
}

package com.patterns.behavioral.command;

public class Main {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl(2); // Remote with 2 slots

        // Create Receivers
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Create Commands and associate them with Receivers
        Command livingRoomLightOn = new LightOnCommand(livingRoomLight);
        Command livingRoomLightOff = new LightOffCommand(livingRoomLight);
        Command kitchenLightOn = new LightOnCommand(kitchenLight);
        Command kitchenLightOff = new LightOffCommand(kitchenLight);

        // Program the remote control slots
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);

        System.out.println(remote);

        System.out.println("--- Simulating Button Presses ---");
        remote.pressOnButton(0);    // Living Room Light ON
        remote.pressOffButton(0);   // Living Room Light OFF
        remote.pressUndoButton();   // Undo: Living Room Light ON
        remote.pressUndoButton();   // Undo: Living Room Light OFF (from original ON)

        System.out.println();
        remote.pressOnButton(1);    // Kitchen Light ON
        remote.pressOnButton(0);    // Living Room Light ON
        remote.pressUndoButton();   // Undo: Living Room Light OFF
        remote.pressOffButton(1);   // Kitchen Light OFF
        remote.pressUndoButton();   // Undo: Kitchen Light ON
        remote.pressUndoButton();   // Undo: Living Room Light ON

        System.out.println("\n--- Current Light States ---");
        System.out.println(livingRoomLight.getLocation() + " Light is " + (livingRoomLight.isOn() ? "ON" : "OFF"));
        System.out.println(kitchenLight.getLocation() + " Light is " + (kitchenLight.isOn() ? "ON" : "OFF"));

        System.out.println("\n--- Testing unassigned slot ---");
        RemoteControl simpleRemote = new RemoteControl(1);
        System.out.println(simpleRemote);
        simpleRemote.pressOnButton(0); // Should execute NoCommand
        simpleRemote.pressUndoButton();  // Should try to undo NoCommand
    }
}

package com.patterns.behavioral.command;

import java.util.Stack;

// Invoker: Asks the command to carry out the request.
public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Stack<Command> commandHistory; // For undo

    public RemoteControl(int numberOfSlots) {
        onCommands = new Command[numberOfSlots];
        offCommands = new Command[numberOfSlots];
        commandHistory = new Stack<>();

        Command noCommand = new NoCommand();
        for (int i = 0; i < numberOfSlots; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot < 0 || slot >= onCommands.length) {
            System.err.println("Invalid slot number: " + slot);
            return;
        }
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void pressOnButton(int slot) {
        if (slot < 0 || slot >= onCommands.length) {
            System.err.println("Invalid slot number: " + slot);
            return;
        }
        System.out.print("Remote: Pressing ON button for slot " + slot + " -> ");
        onCommands[slot].execute();
        commandHistory.push(onCommands[slot]); // Add to history for undo
    }

    public void pressOffButton(int slot) {
        if (slot < 0 || slot >= offCommands.length) {
            System.err.println("Invalid slot number: " + slot);
            return;
        }
        System.out.print("Remote: Pressing OFF button for slot " + slot + " -> ");
        offCommands[slot].execute();
        commandHistory.push(offCommands[slot]); // Add to history for undo
    }

    public void pressUndoButton() {
        System.out.print("Remote: Pressing UNDO button -> ");
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Remote Control -----\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot " + i + "] " + onCommands[i].getClass().getSimpleName()
                    + "   " + offCommands[i].getClass().getSimpleName() + "\n");
        }
        sb.append("[undo] Last Command\n");
        sb.append("------------------------\n");
        return sb.toString();
    }
}

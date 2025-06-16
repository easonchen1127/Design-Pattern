package com.patterns.behavioral.command;

// Null Object pattern can be useful for unassigned slots
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("No command assigned to this slot.");
    }

    @Override
    public void undo() {
        System.out.println("No command to undo.");
    }
}

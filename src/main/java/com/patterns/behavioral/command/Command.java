package com.patterns.behavioral.command;

// Command Interface
public interface Command {
    void execute();
    void undo(); // For supporting undoable operations
}

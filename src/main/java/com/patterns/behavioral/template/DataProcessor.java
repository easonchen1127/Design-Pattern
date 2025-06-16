package com.patterns.behavioral.template;

// AbstractClass: Defines abstract primitive operations that concrete subclasses define
// to implement steps of an algorithm. Implements a template method defining the
// skeleton of an algorithm.
public abstract class DataProcessor {

    // The Template Method - defines the skeleton of the algorithm
    // It's often declared as final to prevent subclasses from overriding the sequence.
    public final void processData() {
        loadData();    // Step 1 (primitive operation, can be overridden)
        transformData(); // Step 2 (primitive operation, can be overridden)
        hookBeforeSave(); // Step 3 (hook, optional override)
        saveData();    // Step 4 (primitive operation, can be overridden)
        hookAfterSave();  // Step 5 (hook, optional override)
        System.out.println(getProcessorType() + ": Data processing complete.");
    }

    // Abstract primitive operations - subclasses MUST implement these
    protected abstract void loadData();
    protected abstract void transformData();
    protected abstract void saveData();

    // Concrete methods (can be part of the algorithm or used by it)
    protected String getProcessorType() {
        return "Generic Data Processor"; // Default type
    }

    // Hooks - subclasses MAY override these.
    // They provide additional extension points in the algorithm.
    protected void hookBeforeSave() {
        // Default implementation does nothing
        System.out.println(getProcessorType() + ": (Hook) No action before save.");
    }

    protected void hookAfterSave() {
        // Default implementation does nothing
        System.out.println(getProcessorType() + ": (Hook) No action after save.");
    }
}

package com.solid.lsp;

public class Penguin extends Bird { // Penguin is a Bird, but not necessarily a FlyingBird
    public Penguin(String name) {
        super(name);
    }

    // Penguin does not implement FlyingBird, so no fly() method is forced upon it from there.
    // It might have its own specific way of "moving" which isn't aerial flight.

    public void swim() {
        System.out.println(getName() + " the Penguin is swimming gracefully.");
    }
}

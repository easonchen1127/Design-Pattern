package com.solid.lsp;

public class Ostrich extends Bird implements NonFlyingBird {
    public Ostrich(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println(getName() + " the Ostrich is running fast!");
    }
}

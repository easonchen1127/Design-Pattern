package com.solid.lsp;

public class Sparrow extends Bird implements FlyingBird {
    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " the Sparrow is soaring through the sky!");
    }
}

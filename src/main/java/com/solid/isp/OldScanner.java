package com.solid.isp;

public class OldScanner implements Scannable {
    private String model;

    public OldScanner(String model) {
        this.model = model;
    }

    @Override
    public void scan() {
        System.out.println(model + " (Old Scanner) is scanning.");
    }

    // No need to implement print() or fax()
}

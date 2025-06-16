package com.solid.isp;

// This class represents a device that can do multiple things
public class MultiFunctionPrinter implements Printable, Scannable, Faxable {
    private String deviceName;

    public MultiFunctionPrinter(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void print() {
        System.out.println(deviceName + " is printing a document.");
    }

    @Override
    public void scan() {
        System.out.println(deviceName + " is scanning a document.");
    }

    @Override
    public void fax() {
        System.out.println(deviceName + " is faxing a document.");
    }
}

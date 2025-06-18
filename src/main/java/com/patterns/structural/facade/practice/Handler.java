package com.patterns.structural.facade.practice;

public class Handler {
    private final String name = this.getClass().getSimpleName();
    private int currentPort;
    private int currentSlot;
    private final int numPort;
    private final int numSlot;

    public Handler(int numPort, int numSlots)
    {
        this.numPort = numPort;
        this.numSlot = numSlots;
    }

    public void initialize()
    {
        System.out.println(name + " has initialized");
    }

    public void getWaferFromCassetteToStage(int port, int slot)
    {
        if(checkPort(port) && checkSlot(slot))
        {
            currentPort = port;
            currentSlot = slot;
            System.out.println(name + " pick up wafer from port: " + port + ", slot: " + slot);
        }
        else
            throw new IllegalArgumentException("Out of range: [port, slot] = [" + port +", " + slot +"]");
    }

    public void getWaferFromStageToCassette(int port, int slot)
    {
        currentPort = port;
        currentSlot = slot;
        System.out.println(name + " return wafer to port: " + port + ", slot: " + slot);
    }


    private boolean checkPort(int port)
    {
        return port >= 1 && port <= numPort;
    }

    private boolean checkSlot(int slot)
    {
        return slot >= 0 && slot <= numSlot;
    }

}

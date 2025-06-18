package com.patterns.structural.proxy.practice;

public class MotorImpl implements IMotor{
    private final String name = this.getClass().getSimpleName();
    private int currentCount;
    public String getMotorName() {
        return name;
    }

    public void home()
    {
        System.out.println(name + "home successfully");
        currentCount = 0;
    }

    public void move(int count) {
        System.out.println(name + "move to " + count);
        currentCount = count;
    }

    public int getCurrentCount() {
        return currentCount;
    }
}

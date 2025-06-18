package com.patterns.structural.proxy.practice;

public class MotorImpl implements IMotor{
    private final String name = this.getClass().getSimpleName();
    private int currentCount;
    public String getMotorName() {
        return name;
    }

    public void home()
    {
        currentCount = 0;
    }

    public void move(int count) {
        currentCount = count;
    }

    public int getCurrentCount() {
        return currentCount;
    }
}

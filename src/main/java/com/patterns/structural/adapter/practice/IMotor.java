package com.patterns.structural.adapter.practice;

public interface IMotor {

    public String getMotorName();
    public void move(int count);
    public void home() throws InterruptedException;
    public int getCurrentCount();
    public boolean isHoming();
}

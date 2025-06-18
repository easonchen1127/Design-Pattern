package com.patterns.structural.proxy.practice;

public interface IMotor {
    public String getMotorName();
    public void home();
    public void move(int count);
    public int getCurrentCount();
}

package com.solid.ocp.practice;

public interface IMotor {
    public void home();
    public void move(int count);
    public String getMotorName();
}

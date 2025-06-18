package com.patterns.structural.proxy.practice;

public class MotorProxy implements IMotor{
    IMotor motor;

    public MotorProxy()
    {
        this.motor = new MotorImpl();
    }

    public String getMotorName() {
        return  motor.getMotorName();
    }

    public void home() {
        motor.home();
    }

    public void move(int count) {
        motor.move(count);
    }

    public int getCurrentCount() {
        return motor.getCurrentCount();
    }
}

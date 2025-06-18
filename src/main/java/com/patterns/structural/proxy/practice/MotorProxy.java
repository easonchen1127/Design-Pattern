package com.patterns.structural.proxy.practice;

public class MotorProxy implements IMotor{
    IMotor motor;
    private final String name;

    public MotorProxy()
    {
        this.motor = new MotorImpl();
        name = motor.getMotorName();
    }

    public String getMotorName() {
        return  motor.getMotorName();
    }

    public void home() {
        motor.home();
        System.out.println(name + "home successfully");
    }

    public void move(int count) {
        motor.move(count);
        System.out.println(name + "move to " + count);
    }

    public int getCurrentCount() {
        return motor.getCurrentCount();
    }
}

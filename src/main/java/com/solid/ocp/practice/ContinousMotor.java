package com.solid.ocp.practice;

public class ContinousMotor implements IMotor{
    private final String name = this.getClass().getName();


    public void home() {
        System.out.println(name + "start to home!");
    }

    public void move(int count) {
        System.out.println(name + "move to:" + count);
    }

    public String getMotorName() {
        return name;
    }
}

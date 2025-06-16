package com.solid.ocp.practice;

public class Stage {
    private final IMotor motor;

    public Stage(IMotor motor)
    {
        if(motor == null)
            throw new IllegalArgumentException("motor is null!");
        this.motor = motor;
    }

    public void Home()
    {
        motor.home();
    }

    public void move(int count)
    {
        motor.move(count);
    }

    public String getMotorName()
    {
        return motor.getMotorName();
    }

}

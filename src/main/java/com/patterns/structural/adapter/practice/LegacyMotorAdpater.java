package com.patterns.structural.adapter.practice;

public class LegacyMotorAdpater implements IMotor{
    private final LegacyMotor legacyMotor;

    public LegacyMotorAdpater(LegacyMotor motor)
    {
        legacyMotor = motor;
    }

    public String getMotorName() {
        return legacyMotor.getMotorName();
    }

    public void move(int count) {
        legacyMotor.move(count);
    }

    public void home() throws InterruptedException {
        legacyMotor.home();
    }

    public int getCurrentCount() {
        return Integer.parseInt(legacyMotor.sendCommand("getCurrentCount"));
    }

    public boolean isHoming() {
        return legacyMotor.sendCommand("isHoming").equals("true");
    }
}

package com.patterns.structural.adapter.practice;

public class LegacyMotor {

    private final String motorName = this.getClass().getSimpleName();
    private int currentCount;

    public String getMotorName()
    {
        return  motorName;
    }

    public void move(int count)
    {
        System.out.println(motorName + " move to " + count);
        currentCount = count;
    }

    public void home() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println(motorName + " home successfully");
        currentCount = 0;
    }

    public String sendCommand(String cmd)
    {
        String result = "";
        System.out.println(motorName + "send command: " + cmd);
        switch (cmd){
            case "getCurrentPos":
                result = "" + currentCount;
            case "isHoming":
                result = (currentCount == 0) ? "true" : "false";
            default:
                result = "This command [" + cmd + "] is not supported";
        }
        return result;
    }
}

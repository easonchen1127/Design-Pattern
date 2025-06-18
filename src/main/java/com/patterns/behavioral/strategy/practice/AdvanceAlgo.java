package com.patterns.behavioral.strategy.practice;

import java.util.Random;

public class AdvanceAlgo implements IAlgo{
    private final String algo = this.getClass().getSimpleName();
    private final Random random = new Random();

    public int getDefectCount() {
        return random.nextInt(1000);
    }

    public String getAlgoName()
    {
        return algo;
    }


    public String displayWaferMap() {
        return "This is the wafer map for simple algo.";
    }

    public int getProcessTime() {
        return random.nextInt(50);
    }
}

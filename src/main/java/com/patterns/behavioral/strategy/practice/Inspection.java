package com.patterns.behavioral.strategy.practice;

public class Inspection {
    private final IAlgo algo;

    public Inspection(IAlgo algo)
    {
        this.algo = algo;
    }

    public void doInspection()
    {
        System.out.println("Inspection is using algo: " + algo.getAlgoName());
        System.out.println("Defect count: " + algo.getDefectCount());
        System.out.println("Process time: " + algo.getProcessTime());
        System.out.println("Wafer map: " + algo.displayWaferMap());
    }
}

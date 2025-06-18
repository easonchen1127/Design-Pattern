package com.patterns.structural.facade.practice;

import java.util.Random;

public class Camera {
    private final String name = this.getClass().getSimpleName();
    private int focusPos;
    private final int minimum = 500;
    private final int maximum = 12000;

    public Camera()
    {

    }

    public void initialize()
    {
        System.out.println(name + " has initialized");
        focusPos = 10000;
    }

    public void focusOnWafer() throws InterruptedException {
        System.out.println(name + " start to focus." );
        Thread.sleep(1000);
        Random random = new Random();
        focusPos = random.nextInt(maximum - minimum) + minimum;
        System.out.println(name + " focus at pos = " + focusPos);
    }


}

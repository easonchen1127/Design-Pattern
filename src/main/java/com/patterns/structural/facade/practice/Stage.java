package com.patterns.structural.facade.practice;

public class Stage {
    private final String name = this.getClass().getSimpleName();
    private int currentX;
    private int currentY;
    private final int limitX = 10000;
    private final int limitY = 20000;

    public Stage()
    {
        currentX = 0;
        currentY = 0;
    }

    public void initialize()
    {
        System.out.println(name + " has initialized");
    }

    public void move(int x, int y)
    {
        if(Math.abs(x)<= limitX && Math.abs(y) <= limitY)
        {
            currentX = x;
            currentY = y;
            System.out.println(name + " move to [x, y] = [" + x + ", " +y + "]" );
        }
        else
            throw new IllegalArgumentException("Out of range: X-limit [" + -limitX + ", " + limitX + "] Y-limit ["
                                                + -limitY + ", " + limitY + "], target [X, Y] = [ " + x + ", " + y + "]" );

    }

    public void home()
    {
        currentX = 0;
        currentY = 0;
        System.out.println(name + "home successfully");
    }
}

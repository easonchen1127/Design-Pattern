package com.patterns.creational.factory.practice;

import java.util.ArrayList;
import java.util.List;

public class OneCake extends FootCenter{
    public OneCake(String restaurant) {
        super(restaurant);
    }

    public void createFoods()
    {
        foods.add(new Cake());
        foods.add(new Soda());
        foods.add(new IceCream());
    }

    public void createDailySet() {
        dailySet = new ArrayList<>();
        dailySet.add(new Cake());
        dailySet.add(new Soda());
        dailySet.add(new IceCream());
    }

}

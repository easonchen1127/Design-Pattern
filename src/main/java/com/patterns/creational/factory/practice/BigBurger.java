package com.patterns.creational.factory.practice;

import java.util.ArrayList;
import java.util.List;

public class BigBurger extends FootCenter{
    public BigBurger(String restaurant) {
        super(restaurant);
    }

    public void createFoods()
    {
        foods.add(new Hambuger());
        foods.add(new Fries());
        foods.add(new Soda());
    }

    public void createDailySet() {
        dailySet = new ArrayList<>();
        dailySet.add(new Hambuger());
        dailySet.add(new Fries());
        dailySet.add(new Soda());
    }


}

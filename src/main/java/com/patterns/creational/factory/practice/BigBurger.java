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

    public void DailySet() {
        String message = "Daily set: " + foods.get(1).getName() + ", " + foods.get(2).getName() + ", " +foods.get(3).getName() + "\n";
        int sum = foods.get(1).getPrice() + foods.get(2).getPrice() + foods.get(3).getPrice();
        int discount = (int) Math.round(0.8 * sum);
        message += "Original price : " + sum + ", Special prices: " + discount;
        System.out.print(message);
    }
}

package com.patterns.creational.factory.practice;

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

    public void DailySet() {
        String message = "Daily set: " + foods.get(1).getName() + ", " + foods.get(2).getName() + "\n";
        int sum = foods.get(1).getPrice() + foods.get(2).getPrice();
        int discount = (int) Math.round(0.8 * sum);
        message += "Original price : " + sum + ", Special prices: " + discount;
        System.out.print(message);
    }
}

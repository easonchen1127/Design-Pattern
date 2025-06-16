package com.patterns.creational.factory.practice;

import java.util.ArrayList;
import java.util.List;

public abstract class FootCenter {
    protected String restaurant = this.getClass().getSimpleName();
    protected List<IFood> foods;

    public FootCenter(String restaurant)
    {
        this.restaurant = restaurant;
    }

    public void createFoods()
    {
        foods = new ArrayList<>();
        foods.add(new Water());
    }


    public void listAllFoods()
    {
        StringBuilder message = new StringBuilder();
        message.append("All foods info:\n");
        for(IFood f : foods)
        {
            message.append("Food: ").append(f.getName()).append(", Price: ").append(f.getPrice()).append(", Expired Date: ").append(f.getExpiredDate()).append("\n");
        }
        System.out.print(message);
    }

    public abstract void DailySet();
}

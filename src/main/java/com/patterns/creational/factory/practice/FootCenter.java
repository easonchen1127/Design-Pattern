package com.patterns.creational.factory.practice;

import java.util.ArrayList;
import java.util.List;

public abstract class FootCenter {
    protected String restaurant = this.getClass().getSimpleName();
    protected List<IFood> foods;
    protected List<IFood> dailySet;

    public FootCenter(String restaurant)
    {
        this.restaurant = restaurant;
    }

    public void createFoods()
    {
        foods = new ArrayList<>();
        foods.add(new Water());
    }

    public abstract void createDailySet();

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

    public void DisplayDailySet() {
        if(dailySet != null && dailySet.size()>1)
        {
            StringBuilder message = new StringBuilder("Daily set: ");
            int sum = 0;

            // Start from index 1 to skip the Water added in the base class.
            for (int i = 1; i < dailySet.size(); i++) {
                IFood food = dailySet.get(i);
                message.append(food.getName());
                if (i < dailySet.size() - 1) {
                    message.append(", ");
                }
                sum += food.getPrice();
            }

            message.append("\n");
            int discount = (int) Math.round(0.8 * sum);
            message.append("Original price : ").append(sum).append(", Special prices: ").append(discount);
            System.out.print(message);
        }
        else
            throw new UnsupportedOperationException("Daily set is not set yet.");

    }
}

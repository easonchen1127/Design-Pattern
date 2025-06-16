package com.patterns.creational.factory.practice;

import java.time.LocalDate;

public class IceCream implements IFood {
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getPrice() {
        return 3;
    }

    public LocalDate getExpiredDate() {
        return LocalDate.now();
    }
}

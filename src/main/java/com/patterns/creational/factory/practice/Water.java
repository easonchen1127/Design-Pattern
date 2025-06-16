package com.patterns.creational.factory.practice;

import java.time.LocalDate;

public class Water implements IFood{
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getPrice() {
        return 0;
    }

    public LocalDate getExpiredDate() {
        return LocalDate.now();
    }
}

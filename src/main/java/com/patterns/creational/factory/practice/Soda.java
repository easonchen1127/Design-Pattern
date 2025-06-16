package com.patterns.creational.factory.practice;

import java.time.LocalDate;

public class Soda implements IFood {
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getPrice() {
        return 1;
    }

    public LocalDate getExpiredDate() {
        return LocalDate.now();
    }
}

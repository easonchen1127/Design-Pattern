package com.patterns.creational.factory.practice;

import java.time.LocalDate;

public class Hambuger implements IFood {
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getPrice() {
        return 5;
    }

    public LocalDate getExpiredDate() {
        return LocalDate.now().plusDays(2);
    }
}

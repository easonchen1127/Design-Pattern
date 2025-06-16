package com.patterns.creational.factory.practice;

import java.time.LocalDate;

public class Cake implements IFood {
    public String getName() {
        return this.getClass().getSimpleName();
    }

    public int getPrice() {
        return 4;
    }

    public LocalDate getExpiredDate() {
        return LocalDate.now().plusDays(1);
    }
}

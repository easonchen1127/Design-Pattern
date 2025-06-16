package com.patterns.creational.factory.practice;

import java.time.LocalDate;

public interface IFood {
    public String getName();
    public int getPrice();
    public LocalDate getExpiredDate();
}

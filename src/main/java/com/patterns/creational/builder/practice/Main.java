package com.patterns.creational.builder.practice;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Building a fun car");
        Car funCar = new Car.Builder("FunCar", "V8-NA", 2)
                .sportMode(true)
                .bodyKit(true)
                .sunRoof(false)
                .build();
        System.out.println(funCar);

        Car Jeep = new Car.Builder("Jeep", "NA enginee", 2)
                .sunRoof(true)
                .build();
        System.out.println(Jeep);
    }
}

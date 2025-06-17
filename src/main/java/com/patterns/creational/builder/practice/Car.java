package com.patterns.creational.builder.practice;

public class Car {
    // Required equipment
    private final String type;
    private final String engine;
    private final int numOfDoors;

    // Optional equipment
    private final boolean withSportMode;
    private final boolean withBodyKit;
    private final boolean withSunRoof;

    private Car(Builder builder)
    {
        this.type = builder.type;
        this.engine = builder.engine;
        this.numOfDoors = builder.numOfDoors;
        this.withSportMode = builder.withSportMode;
        this.withBodyKit = builder.withBodyKit;
        this.withSunRoof = builder.withSunRoof;
    }


    public static class Builder
    {
        // Required equipment
        private final String type;
        private final String engine;
        private final int numOfDoors;

        // Optional equipment
        private boolean withSportMode = false;
        private boolean withBodyKit = false;
        private boolean withSunRoof = false;

        public Builder(String type, String engine, int numOfDoors) {
            if (type == null || engine == null ||
                    type.trim().isEmpty() || engine.trim().isEmpty()
                    || numOfDoors >= 2)
            {
                throw new IllegalArgumentException("CPU and RAM are required and cannot be empty.");
            }
            this.type = type;
            this.engine = engine;
            this.numOfDoors = numOfDoors;
        }

        public Builder sportMode(boolean withSportMode)
        {
            this.withSportMode = withSportMode;
            return this;
        }

        public Builder bodyKit(boolean withBodyKit)
        {
            this.withBodyKit = withBodyKit;
            return this;
        }

        public Builder sunRoof(boolean withSunRoof)
        {
            this.withSunRoof = withSunRoof;
            return this;
        }

        public Car build()
        {
            return new Car(this);
        }
    }

}

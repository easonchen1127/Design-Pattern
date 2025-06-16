package com.solid.srp;

// BAD EXAMPLE - DO NOT USE AS FINAL
public class EmployeeAllInOne {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public EmployeeAllInOne(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    // Responsibility 1: Data holding
    public String getName() { return name; }
    // ... other getters/setters

    // Responsibility 2: Salary Calculation
    public double calculatePay() {
        return hourlyRate * hoursWorked;
    }

    // Responsibility 3: Reporting
    public String generateReport() {
        return "Employee: " + name + "\nPay: $" + calculatePay();
    }

    // Responsibility 4: Persistence (if we added it)
    // public void saveToDatabase() { /* ... */ }
}

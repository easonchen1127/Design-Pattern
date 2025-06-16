package com.solid.srp;

public class    Employee {
    private final String employeeId;
    private final String name;
    private final double hourlyRate;
    private int hoursWorked; // Can change if employee works more/less

    public Employee(String employeeId, String name, double hourlyRate) {
        if (employeeId == null || employeeId.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee ID cannot be null or empty.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be null or empty.");
        }
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate must be positive.");
        }
        this.employeeId = employeeId;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0; // Default hours
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative.");
        }
        this.hoursWorked = hoursWorked;
    }
}

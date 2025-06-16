package com.solid.srp;

public class PayCalculator {
    private static final int REGULAR_HOURS_THRESHOLD = 40;
    private static final double OVERTIME_RATE_MULTIPLIER = 1.5;

    public double calculatePay(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null for pay calculation.");
        }
        int hours = employee.getHoursWorked();
        double rate = employee.getHourlyRate();

        if (hours <= REGULAR_HOURS_THRESHOLD) {
            return hours * rate;
        } else {
            double regularPay = REGULAR_HOURS_THRESHOLD * rate;
            double overtimeHours = hours - REGULAR_HOURS_THRESHOLD;
            double overtimePay = overtimeHours * rate * OVERTIME_RATE_MULTIPLIER;
            return regularPay + overtimePay;
        }
    }
}

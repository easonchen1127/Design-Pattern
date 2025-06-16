package com.solid.srp;

public class EmployeeReporter {
    private final PayCalculator payCalculator;

    public EmployeeReporter(PayCalculator payCalculator) {
        if (payCalculator == null) {
            throw new IllegalArgumentException("PayCalculator cannot be null.");
        }
        this.payCalculator = payCalculator;
    }

    public String generatePaySlip(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null for report generation.");
        }
        double pay = payCalculator.calculatePay(employee);

        StringBuilder report = new StringBuilder();
        report.append("--- Employee Pay Slip ---\n");
        report.append("ID: ").append(employee.getEmployeeId()).append("\n");
        report.append("Name: ").append(employee.getName()).append("\n");
        report.append("Hours Worked: ").append(employee.getHoursWorked()).append("\n");
        report.append("Hourly Rate: $").append(String.format("%.2f", employee.getHourlyRate())).append("\n");
        report.append("Total Pay: $").append(String.format("%.2f", pay)).append("\n");
        report.append("-------------------------\n");

        return report.toString();
    }
}

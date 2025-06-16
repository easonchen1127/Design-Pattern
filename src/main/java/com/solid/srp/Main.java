package com.solid.srp;

public class Main {

    public static void main(String[] args) {
        // Create an employee
        Employee emp1 = new Employee("E001", "Alice Wonderland", 25.0);
        emp1.setHoursWorked(45); // Alice worked 40 regular + 5 overtime hours

        Employee emp2 = new Employee("E002", "Bob The Builder", 20.0);
        emp2.setHoursWorked(30); // Bob worked 30 regular hours

        // Create utility classes
        PayCalculator calculator = new PayCalculator();
        EmployeeReporter reporter = new EmployeeReporter(calculator); // Reporter needs calculator

        // Generate and print payslips
        System.out.println(reporter.generatePaySlip(emp1));
        System.out.println(reporter.generatePaySlip(emp2));

        // Example of how SRP helps:
        // If pay calculation logic changes (e.g. new tax rules), only PayCalculator is modified.
        // If report format changes (e.g. to XML/JSON), only EmployeeReporter is modified.
        // If employee data fields change (e.g. add department), only Employee is modified.
    }
}


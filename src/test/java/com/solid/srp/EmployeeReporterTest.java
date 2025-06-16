package com.solid.srp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

// @ExtendWith(MockitoExtension.class) // Use this if mocking
class EmployeeReporterTest {

    // @Mock // Use this if mocking
    // private PayCalculator mockPayCalculator;

    @Test
    void testGeneratePaySlip() {
        Employee emp = new Employee("PS001", "Peter Slip", 15.0);
        emp.setHoursWorked(40); // 40 * 15 = 600

        PayCalculator realPayCalculator = new PayCalculator(); // Using real one for simplicity here
        EmployeeReporter reporter = new EmployeeReporter(realPayCalculator);

        // If using Mockito:
        // when(mockPayCalculator.calculatePay(emp)).thenReturn(600.0);
        // EmployeeReporter reporter = new EmployeeReporter(mockPayCalculator);

        String paySlip = reporter.generatePaySlip(emp);

        assertTrue(paySlip.contains("ID: PS001"));
        assertTrue(paySlip.contains("Name: Peter Slip"));
        assertTrue(paySlip.contains("Hours Worked: 40"));
        assertTrue(paySlip.contains("Hourly Rate: $15.00"));
        assertTrue(paySlip.contains("Total Pay: $600.00")); // Based on 40 * 15
    }

    @Test
    void testGeneratePaySlipWithOvertime() {
        Employee emp = new Employee("PS002", "Olivia Overtime", 20.0);
        emp.setHoursWorked(45); // 40*20 + 5*20*1.5 = 800 + 150 = 950

        PayCalculator realPayCalculator = new PayCalculator();
        EmployeeReporter reporter = new EmployeeReporter(realPayCalculator);

        String paySlip = reporter.generatePaySlip(emp);

        assertTrue(paySlip.contains("ID: PS002"));
        assertTrue(paySlip.contains("Name: Olivia Overtime"));
        assertTrue(paySlip.contains("Hours Worked: 45"));
        assertTrue(paySlip.contains("Hourly Rate: $20.00"));
        assertTrue(paySlip.contains("Total Pay: $950.00"));
    }

    @Test
    void testConstructorWithNullPayCalculatorThrowsException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new EmployeeReporter(null);
            }
        });
    }

    @Test
    void testGeneratePaySlipWithNullEmployeeThrowsException() {
        PayCalculator calculator = new PayCalculator();
        final EmployeeReporter reporter = new EmployeeReporter(calculator);
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                reporter.generatePaySlip(null);
            }
        });
    }
}

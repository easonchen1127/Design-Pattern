package com.solid.srp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PayCalculatorTest {
    private PayCalculator calculator;
    private Employee regularEmployee;
    private Employee overtimeEmployee;

    @BeforeEach
    void setUp() {
        calculator = new PayCalculator();
        regularEmployee = new Employee("R001", "Regular Ray", 20.0);
        overtimeEmployee = new Employee("O001", "Overtime Ollie", 20.0);
    }

    @Test
    void testCalculatePayRegularHours() {
        regularEmployee.setHoursWorked(40); // 40 hours * $20/hr = $800
        assertEquals(800.0, calculator.calculatePay(regularEmployee), 0.01);
    }

    @Test
    void testCalculatePayLessThanRegularHours() {
        regularEmployee.setHoursWorked(30); // 30 hours * $20/hr = $600
        assertEquals(600.0, calculator.calculatePay(regularEmployee), 0.01);
    }

    @Test
    void testCalculatePayWithOvertime() {
        overtimeEmployee.setHoursWorked(50); // 40 reg * $20 + 10 OT * $20 * 1.5
        // $800 + $300 = $1100
        assertEquals(1100.0, calculator.calculatePay(overtimeEmployee), 0.01);
    }

    @Test
    void testCalculatePayZeroHours() {
        regularEmployee.setHoursWorked(0);
        assertEquals(0.0, calculator.calculatePay(regularEmployee), 0.01);
    }

    @Test
    void testCalculatePayWithNullEmployeeThrowsException() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                calculator.calculatePay(null);
            }
        });
    }
}

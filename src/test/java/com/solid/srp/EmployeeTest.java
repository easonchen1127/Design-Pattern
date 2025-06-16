package com.solid.srp;

import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void testEmployeeCreationAndGetters() {
        Employee emp = new Employee("E123", "John Doe", 30.0);
        assertEquals("E123", emp.getEmployeeId());
        assertEquals("John Doe", emp.getName());
        assertEquals(30.0, emp.getHourlyRate());
        assertEquals(0, emp.getHoursWorked()); // Default
    }

    @Test
    void testSetHoursWorked() {
        Employee emp = new Employee("E124", "Jane Doe", 25.0);
        emp.setHoursWorked(40);
        assertEquals(40, emp.getHoursWorked());
    }

    @Test
    void testSetNegativeHoursWorkedThrowsException() {
        final Employee emp = new Employee("E125", "Test User", 10.0);
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                emp.setHoursWorked(-5);
            }
        });
    }

    @Test
    void testInvalidConstructorArgs() {
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Employee(null, "Test", 10.0);
            }
        });
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Employee("ID", "", 10.0);
            }
        });
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Employee("ID", "Test", 0);
            }
        });
        assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                new Employee("ID", "Test", -5);
            }
        });
    }
}

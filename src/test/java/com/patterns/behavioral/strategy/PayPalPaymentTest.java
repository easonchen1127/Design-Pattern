package com.patterns.behavioral.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PayPalPaymentTest {
    @Test
    void pay_anyAmount_shouldReturnTrue() { // PayPal mock always succeeds in this example
        PaymentStrategy pp = new PayPalPayment("test@example.com", "password");
        assertTrue(pp.pay(50.00));
        assertTrue(pp.pay(50000.00));
    }

    @Test
    void getPaymentMethodName_shouldReturnPayPal() {
        PaymentStrategy pp = new PayPalPayment("test@example.com", "password");
        assertEquals("PayPal", pp.getPaymentMethodName());
    }
}

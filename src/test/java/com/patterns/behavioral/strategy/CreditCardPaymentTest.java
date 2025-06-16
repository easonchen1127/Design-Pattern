package com.patterns.behavioral.strategy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CreditCardPaymentTest {
    @Test
    void pay_withValidAmount_shouldReturnTrue() {
        PaymentStrategy cc = new CreditCardPayment("1111", "Test User", "000", "01/25");
        assertTrue(cc.pay(100.00));
    }

    @Test
    void pay_withAmountOverLimit_shouldReturnFalse() {
        PaymentStrategy cc = new CreditCardPayment("2222", "Test User", "111", "02/26");
        assertFalse(cc.pay(15000.00)); // Assuming limit is 10000
    }

    @Test
    void getPaymentMethodName_shouldReturnCreditCard() {
        PaymentStrategy cc = new CreditCardPayment("3333", "Test User", "222", "03/27");
        assertEquals("Credit Card", cc.getPaymentMethodName());
    }
}

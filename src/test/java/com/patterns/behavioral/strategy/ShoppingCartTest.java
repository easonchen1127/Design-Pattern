package com.patterns.behavioral.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ShoppingCartTest {

    private ShoppingCart cart;

    @Mock
    private PaymentStrategy mockPaymentStrategy;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        // Stub the getPaymentMethodName for logging in setPaymentStrategy
    }

    @Test
    void addItem_increasesTotal() {
        cart.addItem(new Item("Item1", 10.00));
        cart.addItem(new Item("Item2", 20.50));
        assertEquals(30.50, cart.calculateTotal(), 0.001);
    }

    @Test
    void removeItem_decreasesTotal() {
        Item item1 = new Item("Item1", 10.00);
        Item item2 = new Item("Item2", 20.50);
        cart.addItem(item1);
        cart.addItem(item2);
        cart.removeItem(item1);
        assertEquals(20.50, cart.calculateTotal(), 0.001);
    }

    @Test
    void checkout_withNoStrategySet_returnsFalse() {
        cart.addItem(new Item("Test", 1.00));
        assertFalse(cart.checkout(), "Checkout should fail if no payment strategy is set.");
    }

    @Test
    void checkout_withStrategySet_callsPayOnStrategy() {
        cart.addItem(new Item("Product", 50.00));

        when(mockPaymentStrategy.getPaymentMethodName()).thenReturn("MockedStrategyName");
        when(mockPaymentStrategy.pay(50.00)).thenReturn(true); // Stub the pay method

        cart.setPaymentStrategy(mockPaymentStrategy);

        boolean result = cart.checkout();

        assertTrue(result);
        verify(mockPaymentStrategy, times(1)).pay(50.00);
        verify(mockPaymentStrategy, times(1)).getPaymentMethodName();
    }

    @Test
    void checkout_withEmptyCart_returnsTrueAndDoesNotCallPay() {

        when(mockPaymentStrategy.getPaymentMethodName()).thenReturn("MockedStrategyName");
        cart.setPaymentStrategy(mockPaymentStrategy);

        assertTrue(cart.checkout(), "Checkout with empty cart should be considered successful/no-op.");
        verify(mockPaymentStrategy, never()).pay(anyDouble());
        verify(mockPaymentStrategy, times(1)).getPaymentMethodName();
    }

    @Test
    void checkout_strategyPayReturnsFalse_checkoutReturnsFalse() {
        cart.addItem(new Item("Expensive Product", 100.00));

        // ADD STUBBING HERE
        when(mockPaymentStrategy.getPaymentMethodName()).thenReturn("MockedStrategyName");
        when(mockPaymentStrategy.pay(100.00)).thenReturn(false); // Simulate payment failure

        cart.setPaymentStrategy(mockPaymentStrategy);
        boolean result = cart.checkout();

        assertFalse(result, "Checkout should return false if payment strategy fails.");
        verify(mockPaymentStrategy, times(1)).pay(100.00);
        verify(mockPaymentStrategy, times(1)).getPaymentMethodName(); // Called during setPaymentStrategy
    }
}

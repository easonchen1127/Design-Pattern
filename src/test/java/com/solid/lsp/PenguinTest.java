package com.solid.lsp;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class PenguinTest {
    // Test for the initial Penguin that violates LSP by throwing exception on fly()
    // This test would be for the version of Penguin that extends the *first* Bird class
    // and overrides fly() to throw an exception.
    /*
    @Test
    void initialPenguin_fly_throwsUnsupportedOperationException() {
        // Assuming an 'InitialBird' and 'InitialPenguin' for this test
        // Bird penguin = new Penguin("BadPingu"); // Using the version that throws exception
        // assertThrows(UnsupportedOperationException.class, () -> {
        //     penguin.fly();
        // });
    }
    */

    @Test
    void refactoredPenguinCanSwim() {
        Penguin penguin = new Penguin("Pingu"); // Refactored Penguin
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        penguin.swim();
        assertTrue(outContent.toString().contains("Pingu the Penguin is swimming gracefully."));

        System.setOut(originalOut);
    }

    @Test
    void refactoredPenguinCanEat() {
        Penguin penguin = new Penguin("Pingu");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        penguin.eat();
        assertTrue(outContent.toString().contains("Pingu is eating."));
        System.setOut(System.out);
    }
}

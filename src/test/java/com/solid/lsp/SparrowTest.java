package com.solid.lsp;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SparrowTest {
    @Test
    void sparrowCanFly() {
        Sparrow sparrow = new Sparrow("Chirpy");
        // Capture System.out to verify print statements (optional, but good for demo)
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        sparrow.fly();
        assertTrue(outContent.toString().contains("Chirpy the Sparrow is soaring through the sky!"));

        System.setOut(originalOut); // Restore System.out
    }

    @Test
    void sparrowCanEat() {
        Sparrow sparrow = new Sparrow("Chirpy");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        sparrow.eat();
        assertTrue(outContent.toString().contains("Chirpy is eating."));
        System.setOut(System.out);
    }
}

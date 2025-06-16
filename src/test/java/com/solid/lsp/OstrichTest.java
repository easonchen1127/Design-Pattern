package com.solid.lsp;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class OstrichTest {
    @Test
    void ostrichCanWalk() {
        Ostrich ostrich = new Ostrich("Ozzy");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        ostrich.walk();
        assertTrue(outContent.toString().contains("Ozzy the Ostrich is running fast!"));

        System.setOut(originalOut);
    }

    @Test
    void ostrichCanEat() {
        Ostrich ostrich = new Ostrich("Ozzy");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        ostrich.eat();
        assertTrue(outContent.toString().contains("Ozzy is eating."));
        System.setOut(System.out);
    }
}

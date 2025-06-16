package com.solid.lsp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BirdFeeder feeder = new BirdFeeder();

        // --- Using the refactored design ---
        Sparrow refactoredSparrow = new Sparrow("Pip");
        Penguin refactoredPenguin = new Penguin("Pingu"); // Is a Bird, not a FlyingBird
        Ostrich refactoredOstrich = new Ostrich("Ozzy");   // Is a Bird, implements NonFlyingBird

        List<Bird> allBirds = new ArrayList<>();
        allBirds.add(refactoredSparrow);
        allBirds.add(refactoredPenguin);
        allBirds.add(refactoredOstrich);

        feeder.feedAllBirds(allBirds);

        List<FlyingBird> flyingBirdsList = new ArrayList<>();
        flyingBirdsList.add(refactoredSparrow);
        // flyingBirdsList.add(refactoredPenguin); // Compile error: Penguin is not a FlyingBird
        // flyingBirdsList.add(refactoredOstrich); // Compile error: Ostrich is not a FlyingBird

        feeder.makeOnlyFlyingBirdsFly(flyingBirdsList);

        // Demonstrate the problem if we tried to make all birds fly using a generic Bird list
        // when some don't implement FlyingBird (or if Penguin threw an exception in its fly())
        System.out.println("\n--- Demonstrating issue with generic list if not careful (using instanceof) ---");
        feeder.makeBirdsFly(allBirds); // The makeBirdsFly method now checks 'instanceof FlyingBird'

        // Example of Penguin's unique behavior
        refactoredPenguin.swim();
        refactoredOstrich.walk();
    }
}

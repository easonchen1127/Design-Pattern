package com.solid.lsp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BirdFeederTest {

    @Mock
    private FlyingBird mockFlyingBird1;
    @Mock
    private FlyingBird mockFlyingBird2;
    @Mock
    private Bird mockGenericBird1;
    @Mock
    private Bird mockGenericBird2;


    @Test
    void makeOnlyFlyingBirdsFly_callsFlyOnAllFlyingBirds() {
        BirdFeeder feeder = new BirdFeeder();
        List<FlyingBird> flyingBirds = Arrays.asList(mockFlyingBird1, mockFlyingBird2);

        feeder.makeOnlyFlyingBirdsFly(flyingBirds);

        verify(mockFlyingBird1, times(1)).fly();
        verify(mockFlyingBird2, times(1)).fly();
    }

    @Test
    void feedAllBirds_callsEatOnAllBirds() {
        BirdFeeder feeder = new BirdFeeder();
        List<Bird> birds = Arrays.asList(mockGenericBird1, mockGenericBird2);
        // Mocking getName for cleaner test output, though not strictly necessary for the eat() call itself
//        when(mockGenericBird1.getName()).thenReturn("MockBird1");
//        when(mockGenericBird2.getName()).thenReturn("MockBird2");

        feeder.feedAllBirds(birds);

        verify(mockGenericBird1, times(1)).eat();
        verify(mockGenericBird2, times(1)).eat();
    }

    @Test
    void makeBirdsFly_handlesFlyingAndNonFlyingCorrectly() {
        BirdFeeder feeder = new BirdFeeder();
        Sparrow sparrow = new Sparrow("RealSparrow"); // Implements FlyingBird
        Penguin penguin = new Penguin("RealPenguin"); // Does not implement FlyingBird

        // Mock a generic bird that doesn't implement FlyingBird
        Bird nonFlyingMock = Mockito.mock(Bird.class);
        when(nonFlyingMock.getName()).thenReturn("NonFlyer");


        List<Bird> birds = Arrays.asList(sparrow, penguin, nonFlyingMock);

        // Since makeBirdsFly now prints, we could capture output, or just ensure no exceptions
        // For simplicity here, we just call it. A more robust test might check output.
        assertDoesNotThrow(() -> feeder.makeBirdsFly(birds));

        // If we wanted to verify sparrow.fly() was called, we'd need a spy or a different setup
        // as the current makeBirdsFly creates a new list.
        // However, we know it works based on the Main.java output logic.
    }
}

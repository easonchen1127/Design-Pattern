package com.patterns.structural.facade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HomeTheaterFacadeTest {

    @Mock private Amplifier mockAmplifier;
    @Mock private DvdPlayer mockDvdPlayer;
    @Mock private Projector mockProjector;
    @Mock private Screen mockScreen;
    @Mock private TheaterLights mockLights;

    private HomeTheaterFacade facade;

    @BeforeEach
    void setUp() {
        facade = new HomeTheaterFacade(mockAmplifier, mockDvdPlayer, mockProjector, mockScreen, mockLights);
    }

    @Test
    void watchMovie_orchestratesSubsystemComponentsCorrectly() {
        String movie = "The Matrix";
        facade.watchMovie(movie);

        // Verify methods are called on mocks in the correct order for watchMovie
        InOrder inOrder = inOrder(mockLights, mockScreen, mockProjector, mockAmplifier, mockDvdPlayer);

        inOrder.verify(mockLights).dim(10);
        inOrder.verify(mockScreen).down();
        inOrder.verify(mockProjector).on();
        inOrder.verify(mockProjector).wideScreenMode();
        inOrder.verify(mockAmplifier).on();
        inOrder.verify(mockAmplifier).setSurroundSound();
        inOrder.verify(mockAmplifier).setVolume(25);
        inOrder.verify(mockDvdPlayer).on();
        inOrder.verify(mockDvdPlayer).play(movie);
    }

    @Test
    void endMovie_orchestratesSubsystemComponentsCorrectly() {
        facade.endMovie();

        InOrder inOrder = inOrder(mockDvdPlayer, mockAmplifier, mockProjector, mockScreen, mockLights);

        inOrder.verify(mockDvdPlayer).stop();
        inOrder.verify(mockDvdPlayer).eject();
        inOrder.verify(mockDvdPlayer).off();
        inOrder.verify(mockAmplifier).off();
        inOrder.verify(mockProjector).off();
        inOrder.verify(mockScreen).up();
        inOrder.verify(mockLights).on();
    }

    @Test
    void listenToMusic_orchestratesSubsystemCorrectly() {
        facade.listenToMusic();

        InOrder inOrder = inOrder(mockLights, mockAmplifier, mockDvdPlayer);
        inOrder.verify(mockLights).dim(50);
        inOrder.verify(mockAmplifier).on();
        inOrder.verify(mockAmplifier).setVolume(30);
        inOrder.verify(mockDvdPlayer).on();
        inOrder.verify(mockDvdPlayer).play("Favorite Music Album");
    }

    @Test
    void endMusic_orchestratesSubsystemCorrectly() {
        facade.endMusic();

        InOrder inOrder = inOrder(mockDvdPlayer, mockAmplifier, mockLights);
        inOrder.verify(mockDvdPlayer).stop();
        inOrder.verify(mockDvdPlayer).off();
        inOrder.verify(mockAmplifier).off();
        inOrder.verify(mockLights).on();
    }
}

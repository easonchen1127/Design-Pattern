package com.patterns.behavioral.command;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LightCommandsTest {

    @Mock
    private Light mockLight;

    @Test
    void lightOnCommand_execute_callsLightOn() {
        LightOnCommand onCommand = new LightOnCommand(mockLight);
        onCommand.execute();
        verify(mockLight, times(1)).on();
    }

    @Test
    void lightOnCommand_undo_callsLightOff() {
        LightOnCommand onCommand = new LightOnCommand(mockLight);
        onCommand.undo();
        verify(mockLight, times(1)).off();
    }

    @Test
    void lightOffCommand_execute_callsLightOff() {
        LightOffCommand offCommand = new LightOffCommand(mockLight);
        offCommand.execute();
        verify(mockLight, times(1)).off();
    }

    @Test
    void lightOffCommand_undo_callsLightOn() {
        LightOffCommand offCommand = new LightOffCommand(mockLight);
        offCommand.undo();
        verify(mockLight, times(1)).on();
    }
}

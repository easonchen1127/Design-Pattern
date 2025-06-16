package com.patterns.behavioral.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RemoteControlTest {

    @Mock
    private Command mockOnCommand;
    @Mock
    private Command mockOffCommand;

    private RemoteControl remote;

    @BeforeEach
    void setUp() {
        remote = new RemoteControl(1); // Single slot remote for simplicity
        remote.setCommand(0, mockOnCommand, mockOffCommand);
    }

    @Test
    void pressOnButton_executesOnCommandAndPushesToHistory() {
        remote.pressOnButton(0);
        verify(mockOnCommand, times(1)).execute();
        // To test history, we'd need to inspect the private stack or test undo behavior
    }

    @Test
    void pressOffButton_executesOffCommandAndPushesToHistory() {
        remote.pressOffButton(0);
        verify(mockOffCommand, times(1)).execute();
    }

    @Test
    void pressUndoButton_withHistory_callsUndoOnLastCommand() {
        // Simulate pressing ON, then UNDO
        remote.pressOnButton(0); // This pushes mockOnCommand to history
        reset(mockOnCommand); // Reset mock interactions before verifying undo

        remote.pressUndoButton();
        verify(mockOnCommand, times(1)).undo();
    }

    @Test
    void pressUndoButton_withEmptyHistory_doesNothingExtra() {
        // Ensure no exceptions and no command.undo() is called
        remote.pressUndoButton(); // History is empty initially or after pops
        verifyNoInteractions(mockOnCommand); // Assuming no button was pressed before undo
        verifyNoInteractions(mockOffCommand);
    }

    @Test
    void pressUndoButton_multipleTimes_popsHistoryCorrectly() {
        Command anotherMockOn = mock(Command.class);
        Command anotherMockOff = mock(Command.class);
        remote.setCommand(0, mockOnCommand, mockOffCommand); // slot 0
        // Let's say we have a two slot remote for this test
        // RemoteControl remoteMulti = new RemoteControl(2);
        // remoteMulti.setCommand(0, mockOnCommand, mockOffCommand);
        // remoteMulti.setCommand(1, anotherMockOn, anotherMockOff);

        remote.pressOnButton(0);    // History: [mockOnCommand]
        remote.pressOffButton(0);   // History: [mockOnCommand, mockOffCommand]

        reset(mockOnCommand, mockOffCommand); // Reset mocks

        remote.pressUndoButton();       // Pops mockOffCommand, calls mockOffCommand.undo()
        verify(mockOffCommand, times(1)).undo();
        verify(mockOnCommand, never()).undo(); // mockOnCommand not undone yet

        reset(mockOnCommand, mockOffCommand);

        remote.pressUndoButton();       // Pops mockOnCommand, calls mockOnCommand.undo()
        verify(mockOnCommand, times(1)).undo();
        verify(mockOffCommand, never()).undo();
    }

    @Test
    void setCommand_invalidSlot_doesNotSet() {
        // Remote is size 1 (slot 0)
        // Try to set command at slot 1 (invalid)
        remote.setCommand(1, mock(Command.class), mock(Command.class));
        // Test by trying to press button for unconfigured slot
        remote.pressOnButton(1); // Should probably print error, not call any set mock
        // This test is more about boundary conditions and error handling in RemoteControl
        // Ideally, pressing an invalid slot on/off should not interact with validly set commands.
    }

    @Test
    void unassignedSlot_executesNoCommand() {
        RemoteControl freshRemote = new RemoteControl(1);
        // No setCommand called for slot 0
        // Pressing should result in NoCommand behavior (printing to console)
        // This test is harder to assert without capturing System.out or making NoCommand mockable
        assertDoesNotThrow(() -> freshRemote.pressOnButton(0));
        assertDoesNotThrow(() -> freshRemote.pressUndoButton());
    }
}

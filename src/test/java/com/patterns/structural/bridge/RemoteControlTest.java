package com.patterns.structural.bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RemoteControlTest {

    @Mock
    private Device mockDevice;

    @Test
    void basicRemote_togglePower_callsDeviceEnableOrDisable() {
        RemoteControl basicRemote = new BasicRemote(mockDevice);

        // Test turning ON
        when(mockDevice.isEnabled()).thenReturn(false);
        basicRemote.togglePower();
        verify(mockDevice, times(1)).enable();
        verify(mockDevice, never()).disable();

        reset(mockDevice); // Reset mock for next interaction

        // Test turning OFF
        when(mockDevice.isEnabled()).thenReturn(true);
        basicRemote.togglePower();
        verify(mockDevice, times(1)).disable();
        verify(mockDevice, never()).enable();
    }

    @Test
    void basicRemote_volumeUp_callsDeviceSetVolume() {
        RemoteControl basicRemote = new BasicRemote(mockDevice);
        when(mockDevice.isEnabled()).thenReturn(true);
        when(mockDevice.getVolume()).thenReturn(50);

        basicRemote.volumeUp();
        verify(mockDevice, times(1)).setVolume(55);
    }

    @Test
    void advancedRemote_mute_callsDeviceSetVolumeToZero() {
        AdvancedRemote advancedRemote = new AdvancedRemote(mockDevice);
        when(mockDevice.isEnabled()).thenReturn(true);

        advancedRemote.mute();
        verify(mockDevice, times(1)).setVolume(0);
    }

    @Test
    void advancedRemote_setFavoriteChannel_callsDeviceSetChannel() {
        AdvancedRemote advancedRemote = new AdvancedRemote(mockDevice);
        when(mockDevice.isEnabled()).thenReturn(true);

        advancedRemote.setFavoriteChannel(77);
        verify(mockDevice, times(1)).setChannel(77);
    }

    @Test
    void constructor_nullDevice_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> new BasicRemote(null));
        assertThrows(IllegalArgumentException.class, () -> new AdvancedRemote(null));
    }

    @Test
    void operations_whenDeviceDisabled_doesNotCallDeviceMethods() {
        RemoteControl basicRemote = new BasicRemote(mockDevice);
        when(mockDevice.isEnabled()).thenReturn(false); // Device is OFF

        basicRemote.volumeUp();
        basicRemote.volumeDown();
        basicRemote.channelUp();
        basicRemote.channelDown();

        verify(mockDevice, never()).setVolume(anyInt());
        verify(mockDevice, never()).setChannel(anyInt());

        AdvancedRemote advancedRemote = new AdvancedRemote(mockDevice);
        when(mockDevice.isEnabled()).thenReturn(false); // Device is OFF
        advancedRemote.mute();
        advancedRemote.setFavoriteChannel(5);
        verify(mockDevice, never()).setVolume(anyInt()); // still never from advanced remote calls
        verify(mockDevice, never()).setChannel(anyInt());
    }
}

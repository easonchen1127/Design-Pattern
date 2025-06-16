package com.patterns.structural.bridge;

public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
        System.out.println("AdvancedRemote configured for device: " + device.getClass().getSimpleName());
    }

    public void mute() {
        if (device.isEnabled()) {
            System.out.println("AdvancedRemote: Muting device.");
            device.setVolume(0);
        } else {
            System.out.println("Cannot mute. Device is OFF.");
        }
    }

    public void setFavoriteChannel(int channel) {
        if (device.isEnabled()) {
            System.out.println("AdvancedRemote: Setting favorite channel to " + channel);
            device.setChannel(channel);
        } else {
            System.out.println("Cannot set favorite channel. Device is OFF.");
        }
    }
}

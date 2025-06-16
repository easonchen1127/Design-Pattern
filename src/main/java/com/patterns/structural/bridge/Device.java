package com.patterns.structural.bridge;

// Implementor: Defines the interface for implementation classes.
// This interface doesn't have to match Abstraction's interface.
public interface Device {
    boolean isEnabled();
    void enable();
    void disable();
    int getVolume();
    void setVolume(int percent);
    int getChannel();
    void setChannel(int channel);
    String getStatus();
}

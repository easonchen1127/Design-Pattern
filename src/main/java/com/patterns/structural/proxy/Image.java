package com.patterns.structural.proxy;

// Subject: Defines the common interface for RealSubject and Proxy
// so that a Proxy can be used anywhere a RealSubject is expected.
public interface Image {
    void display();
    String getFileName();
}

package com.patterns.structural.proxy;

// RealSubject: Defines the real object that the proxy represents.
public class RealImage implements Image {
    private final String fileName;
    private final String content; // Simulate image content

    public RealImage(String fileName) {
        this.fileName = fileName;
        this.content = loadImageFromDisk(fileName); // Expensive operation
        System.out.println("RealImage: Loaded image '" + fileName + "' from disk.");
    }

    private String loadImageFromDisk(String fileName) {
        // Simulate a time-consuming disk read operation
        System.out.println("RealImage: Simulating loading '" + fileName + "' (takes time)...");
        try {
            Thread.sleep(1500); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("RealImage: Loading interrupted for " + fileName);
        }
        return "Pixel data for " + fileName;
    }

    @Override
    public void display() {
        System.out.println("RealImage: Displaying image '" + fileName + "'. Content: " + content);
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}

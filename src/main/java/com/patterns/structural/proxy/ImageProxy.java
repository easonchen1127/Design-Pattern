package com.patterns.structural.proxy;

// Proxy: Maintains a reference that lets the proxy access the real subject.
// Proxy may refer to a RealSubject if the RealSubject interface is used.
// Provides an interface identical to Subject's.
public class ImageProxy implements Image {
    private final String fileName;
    private RealImage realImage; // Reference to the RealSubject (lazy initialized)

    public ImageProxy(String fileName) {
        this.fileName = fileName;
        System.out.println("ImageProxy: Created for '" + fileName + "' (RealImage not loaded yet).");
    }

    @Override
    public void display() {
        // Lazy initialization: Load RealImage only when display() is called
        if (realImage == null) {
            System.out.println("ImageProxy: RealImage for '" + fileName + "' needs to be loaded.");
            realImage = new RealImage(fileName);
        }
        System.out.println("ImageProxy: Delegating display call to RealImage for '" + fileName + "'.");
        realImage.display(); // Delegate to the real subject
    }

    @Override
    public String getFileName() {
        // Can return immediately without loading the RealImage if needed for some metadata
        return fileName;
    }

    // Proxy can add other functionalities, e.g., caching, access control
    public boolean isLoaded() {
        return realImage != null;
    }
}

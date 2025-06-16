package com.patterns.structural.proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Using ImageProxy ---");

        // Client interacts with the Proxy, not directly with RealImage initially
        Image image1 = new ImageProxy("photo_album_cover.jpg");
        Image image2 = new ImageProxy("user_profile_avatar.png");

        System.out.println("\nProxy for image1 created. File: " + image1.getFileName());
        System.out.println("Proxy for image2 created. File: " + image2.getFileName());

        // RealImage for image1 is loaded only when display() is called
        System.out.println("\nAttempting to display image1 for the first time:");
        image1.display();

        // RealImage for image1 is already loaded, so display() is faster
        System.out.println("\nAttempting to display image1 again:");
        image1.display();

        // RealImage for image2 is loaded only when display() is called
        System.out.println("\nAttempting to display image2 for the first time:");
        image2.display();

        System.out.println("\n--- Checking loaded status (Proxy specific method) ---");
        if (image1 instanceof ImageProxy) {
            System.out.println("image1 is loaded: " + ((ImageProxy) image1).isLoaded()); // true
        }
        Image image3 = new ImageProxy("not_yet_displayed.gif");
        if (image3 instanceof ImageProxy) {
            System.out.println("image3 is loaded: " + ((ImageProxy) image3).isLoaded()); // false
        }

        System.out.println("\n--- Direct use of RealImage (for comparison) ---");
        // This would load the image immediately upon creation
        // Image realImageDirect = new RealImage("direct_load.jpg");
        // realImageDirect.display();
    }
}

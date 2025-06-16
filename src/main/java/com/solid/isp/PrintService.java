package com.solid.isp;

public class PrintService {
    public void sendToPrinter(Printable documentOrDevice) {
        System.out.print("PrintService: Sending to print -> ");
        documentOrDevice.print(); // Only depends on the print() method
    }
}

package com.solid.isp;

public class ScanService {
    public void performScan(Scannable device) {
        System.out.print("ScanService: Initiating scan -> ");
        device.scan(); // Only depends on the scan() method
    }
}

package com.solid.isp;

public class Main {
    public static void main(String[] args) {
        PrintService printService = new PrintService();
        ScanService scanService = new ScanService();

        SimpleTextDocument myDoc = new SimpleTextDocument("This is my important essay about ISP.");
        MultiFunctionPrinter mfp = new MultiFunctionPrinter("OfficeJet Pro 8020");
        OldScanner oldScanDevice = new OldScanner("CanonScan LiDE 100");

        System.out.println("--- Using PrintService ---");
        printService.sendToPrinter(myDoc);    // myDoc is Printable
        printService.sendToPrinter(mfp);      // mfp is Printable
        // printService.sendToPrinter(oldScanDevice); // Compile Error: OldScanner is not Printable

        System.out.println("\n--- Using ScanService ---");
        scanService.performScan(mfp);           // mfp is Scannable
        scanService.performScan(oldScanDevice); // oldScanDevice is Scannable
        // scanService.performScan(myDoc);         // Compile Error: SimpleTextDocument is not Scannable

        System.out.println("\n--- MFP specific operations (if needed directly) ---");
        if (mfp instanceof Faxable) { // Example of checking specific capability if needed
            ((Faxable) mfp).fax();
        }
    }
}

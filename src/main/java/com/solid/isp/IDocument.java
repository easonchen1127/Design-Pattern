package com.solid.isp;

// THIS IS THE "FAT" INTERFACE WE WANT TO AVOID
public interface IDocument {
    void open(String filePath);
    void save(String filePath);
    void print();    // Not all documents/devices can print
    void scan();     // Not all documents/devices can scan
    void fax();      // Not all documents/devices can fax
    // ... other potential document operations
}

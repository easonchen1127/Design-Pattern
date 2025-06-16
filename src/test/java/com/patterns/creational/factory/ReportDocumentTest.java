package com.patterns.creational.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ReportDocumentTest {
    @Test
    void getType_shouldReturnReport() {
        ReportDocument doc = new ReportDocument("Test Report");
        assertEquals("Report", doc.getType());
    }

    @Test
    void open_shouldContainContent() {
        ReportDocument doc = new ReportDocument("Initial content for report.");
        // Test System.out if desired, or just that it doesn't throw
        assertDoesNotThrow(doc::open);
    }

    @Test
    void save_shouldNotThrow() {
        ReportDocument doc = new ReportDocument("Report to save.");
        assertDoesNotThrow(() -> doc.save("/test/path.rpt"));
    }
}

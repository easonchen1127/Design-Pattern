package com.patterns.creational.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StandardDocumentCreatorTest {
    private final DocumentCreator creator = new StandardDocumentCreator();

    @Test
    void createDocument_reportType_shouldReturnReportDocument() {
        Document doc = creator.createDocument("report", "Test Report Content");
        assertNotNull(doc);
        assertTrue(doc instanceof ReportDocument);
        assertEquals("Report", doc.getType());
    }

    @Test
    void createDocument_spreadsheetType_shouldReturnSpreadsheetDocument() {
        Document doc = creator.createDocument("spreadsheet", "50", "10");
        assertNotNull(doc);
        assertTrue(doc instanceof SpreadsheetDocument);
        assertEquals("Spreadsheet", doc.getType());
    }

    @Test
    void createDocument_spreadsheetType_defaultParams_shouldWork() {
        Document doc = creator.createDocument("spreadsheet");
        assertNotNull(doc);
        assertTrue(doc instanceof SpreadsheetDocument);
    }

    @Test
    void createDocument_unknownType_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            creator.createDocument("unknownType");
        });
    }

    @Test
    void newDocument_usesCreateDocument() {
        // This tests the abstract creator's method that uses the factory method
        Document doc = creator.newDocument("report", "From newDocument");
        assertNotNull(doc);
        assertTrue(doc instanceof ReportDocument);
    }
}

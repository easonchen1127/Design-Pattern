package com.patterns.creational.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpreadsheetDocumentTest {
    @Test
    void getType_shouldReturnSpreadsheet() {
        SpreadsheetDocument doc = new SpreadsheetDocument(10, 5);
        assertEquals("Spreadsheet", doc.getType());
    }

    @Test
    void open_shouldNotThrow() {
        SpreadsheetDocument doc = new SpreadsheetDocument(5, 5);
        assertDoesNotThrow(doc::open);
    }

    @Test
    void save_shouldNotThrow() {
        SpreadsheetDocument doc = new SpreadsheetDocument(20, 10);
        assertDoesNotThrow(() -> doc.save("/test/sheet.xlsx"));
    }
}

package com.patterns.creational.factory;

// Concrete Creator
public class StandardDocumentCreator extends DocumentCreator {

    @Override
    protected Document createDocument(String type, String... params) {
        switch (type.toLowerCase()) {
            case "report" -> {
                String initialContent = (params.length > 0) ? params[0] : "Default Report Content";
                return new ReportDocument(initialContent);
            }
            case "spreadsheet" -> {
                int rows = (params.length > 0) ? Integer.parseInt(params[0]) : 10;
                int cols = (params.length > 1) ? Integer.parseInt(params[1]) : 5;
                return new SpreadsheetDocument(rows, cols);
            }
            default -> throw new IllegalArgumentException("Unknown document type: " + type);
        }
    }
}

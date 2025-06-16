package com.patterns.creational.factory;

public class Main {
    public static void main(String[] args) {
        // Client uses a Concrete Creator
        DocumentCreator creator = new StandardDocumentCreator();

        System.out.println("--- Creating a Report Document ---");
        Document report = creator.newDocument("report", "Annual Financial Summary");
        if (report instanceof ReportDocument) {
            ((ReportDocument) report).addPage("Appendix A: Detailed Figures");
        }
        creator.processDocument(report, "/path/to/annual_report.rpt");

        System.out.println("\n--- Creating a Spreadsheet Document ---");
        Document spreadsheet = creator.newDocument("spreadsheet", "100", "20"); // 100 rows, 20 columns
        if (spreadsheet instanceof SpreadsheetDocument) {
            ((SpreadsheetDocument) spreadsheet).setCellValue(1, 1, "Q1 Sales");
        }
        creator.processDocument(spreadsheet, "/path/to/sales_data.xlsx");

        System.out.println("\n--- Attempting to create an unknown document type ---");
        try {
            creator.newDocument("invoice");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // One could also have other DocumentCreator implementations, e.g., SecureDocumentCreator
        // that creates encrypted versions of documents, still using the same Document interface.
    }
}

package com.patterns.creational.factory;

public class SpreadsheetDocument implements Document {
    private int rows;
    private int columns;

    public SpreadsheetDocument(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        System.out.println("SpreadsheetDocument created with " + rows + " rows and " + columns + " columns.");
    }

    @Override
    public void open() {
        System.out.println("Opening SpreadsheetDocument [" + rows + "x" + columns + "].");
    }

    @Override
    public void save(String path) {
        System.out.println("Saving SpreadsheetDocument to: " + path);
        // Actual save logic would go here
    }

    @Override
    public String getType() {
        return "Spreadsheet";
    }

    public void setCellValue(int row, int col, String value) {
        System.out.println("Setting cell (" + row + "," + col + ") in SpreadsheetDocument to: " + value);
    }
}

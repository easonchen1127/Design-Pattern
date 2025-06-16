package com.patterns.behavioral.template;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Processing CSV Data ---");
        DataProcessor csvProcessor = new CsvDataProcessor("data/sales_report.csv");
        csvProcessor.processData(); // Call the template method

        System.out.println("\n--- Processing Database Data ---");
        DataProcessor dbProcessor = new DatabaseDataProcessor("jdbc:mydb://localhost/prod_db");
        dbProcessor.processData(); // Call the template method
    }
}

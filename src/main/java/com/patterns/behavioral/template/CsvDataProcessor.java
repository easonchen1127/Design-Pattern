package com.patterns.behavioral.template;

// ConcreteClass: Implements the primitive operations to carry out subclass-specific
// steps of the algorithm.
public class CsvDataProcessor extends DataProcessor {
    private String filePath;
    private String processedContent;

    public CsvDataProcessor(String filePath) {
        this.filePath = filePath;
    }

    @Override
    protected void loadData() {
        System.out.println("CSV Processor: Loading data from CSV file: " + filePath);
        // Simulate loading data
        this.processedContent = "raw_csv_data_from_" + filePath;
    }

    @Override
    protected void transformData() {
        System.out.println("CSV Processor: Transforming CSV data (e.g., parsing, cleaning).");
        this.processedContent = this.processedContent.toUpperCase().replace("_", " ");
    }

    @Override
    protected void saveData() {
        System.out.println("CSV Processor: Saving transformed data to a new CSV/report file. Content: "
                + processedContent.substring(0, Math.min(30, processedContent.length())) + "...");
    }

    @Override
    protected String getProcessorType() {
        return "CSV Data Processor";
    }

    // Overriding a hook
    @Override
    protected void hookAfterSave() {
        System.out.println("CSV Processor: (Hook) Archiving original CSV file: " + filePath);
    }
}

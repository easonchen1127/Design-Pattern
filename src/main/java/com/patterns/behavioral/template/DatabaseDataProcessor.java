package com.patterns.behavioral.template;

// Another ConcreteClass
public class DatabaseDataProcessor extends DataProcessor {
    private String connectionString;
    private String queryResult;

    public DatabaseDataProcessor(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    protected void loadData() {
        System.out.println("DB Processor: Connecting to database: " + connectionString);
        System.out.println("DB Processor: Executing query and loading data from database.");
        // Simulate loading data
        this.queryResult = "raw_db_query_result";
    }

    @Override
    protected void transformData() {
        System.out.println("DB Processor: Transforming database results (e.g., mapping to objects, aggregation).");
        this.queryResult = "TRANSFORMED(" + this.queryResult + ")";
    }

    @Override
    protected void saveData() {
        System.out.println("DB Processor: Saving transformed data back to database or a data warehouse. Result: "
                + queryResult.substring(0, Math.min(30, queryResult.length())) + "...");
    }

    @Override
    protected String getProcessorType() {
        return "Database Data Processor";
    }

    // Overriding a different hook
    @Override
    protected void hookBeforeSave() {
        System.out.println("DB Processor: (Hook) Starting database transaction before saving.");
    }
}

package com.patterns.creational.factory;

public class ReportDocument implements Document {
    private String content;

    public ReportDocument(String initialContent) {
        this.content = initialContent;
        System.out.println("ReportDocument created with initial content.");
    }

    @Override
    public void open() {
        System.out.println("Opening ReportDocument. Content: " + content.substring(0, Math.min(30, content.length())) + "...");
    }

    @Override
    public void save(String path) {
        System.out.println("Saving ReportDocument to: " + path);
        // Actual save logic would go here
    }

    @Override
    public String getType() {
        return "Report";
    }

    public void addPage(String pageContent) {
        this.content += "\n---\n" + pageContent;
        System.out.println("Page added to ReportDocument.");
    }
}

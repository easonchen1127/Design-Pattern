package com.solid.isp;

public class SimpleTextDocument implements Printable {
    private String content;

    public SimpleTextDocument(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void print() {
        System.out.println("Printing SimpleTextDocument: " + content.substring(0, Math.min(content.length(), 30)) + "...");
    }

    // No need to implement scan() or fax()
}

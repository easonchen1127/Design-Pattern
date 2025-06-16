package com.patterns.creational.factory;

// Abstract Creator
public abstract class DocumentCreator {

    // The Factory Method - subclasses will override this to create specific document types
    protected abstract Document createDocument(String type, String... params);

    // Some operation that uses the product created by the factory method
    public Document newDocument(String type, String... params) {
        // Call the factory method to get the Document object
        Document doc = createDocument(type, params);
        // Perform some common operations on the document if needed
        // For example, logging creation, registering the document, etc.
        System.out.println(doc.getType() + " document instance requested and created by factory.");
        return doc;
    }

    // Other common operations for creators could go here
    public void processDocument(Document doc, String savePath) {
        doc.open();
        // ... some processing ...
        doc.save(savePath);
        System.out.println(doc.getType() + " document processed.");
    }
}

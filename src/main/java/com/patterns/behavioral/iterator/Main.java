package com.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookCollection bookCollection = new BookCollection();
        bookCollection.addBook(new Book("Design Patterns", "GoF", "978-0201633610"));
        bookCollection.addBook(new Book("Clean Code", "Robert C. Martin", "978-0132350884"));
        bookCollection.addBook(new Book("The Pragmatic Programmer", "Andrew Hunt", "978-0201616224"));
        bookCollection.addBook(new Book("Effective Java", "Joshua Bloch", "978-0134685991"));

        System.out.println("--- Iterating through Book Collection (Custom Iterator) ---");
        Iterator<Book> iterator = bookCollection.createIterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }

        System.out.println("\n--- Iterating again (new iterator instance) ---");
        Iterator<Book> iterator2 = bookCollection.createIterator();
        while (iterator2.hasNext()) {
            Book book = iterator2.next();
            System.out.println("Title: " + book.getTitle());
        }

        // For comparison, if BookCollection directly exposed its list (which Iterator pattern helps avoid):
        // System.out.println("\n--- Accessing directly (if list was public) ---");
        // for (Book book : bookCollection.getBooksInternalList()) { // Assuming such a getter
        //     System.out.println(book.getAuthor());
        // }

        // Using Java's built-in Iterator and Iterable (a more common Java approach)
        System.out.println("\n--- Using Java's built-in Iterable/Iterator (Recommended in Java) ---");
        BookCollectionWithJavaIterable bookCollectionJava = new BookCollectionWithJavaIterable();
        bookCollectionJava.addBook(new Book("Refactoring", "Martin Fowler", "978-0201485677"));
        bookCollectionJava.addBook(new Book("Domain-Driven Design", "Eric Evans", "978-0321125217"));

        for (Book book : bookCollectionJava) { // Enhanced for-loop works because it implements Iterable
            System.out.println(book);
        }
    }
}

// Helper class to show how Java's built-in Iterable would be used
class BookCollectionWithJavaIterable implements Iterable<Book> {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    @Override
    public java.util.Iterator<Book> iterator() { // Note: java.util.Iterator
        return books.iterator(); // ArrayList's iterator is used directly
    }
}

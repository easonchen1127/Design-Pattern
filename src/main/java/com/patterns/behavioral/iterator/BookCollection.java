package com.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

// ConcreteAggregate
public class BookCollection implements Aggregate<Book> {
    private final List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    public int getCount() {
        return books.size();
    }

    @Override
    public Iterator<Book> createIterator() {
        return new BookIterator(this.books);
    }

    // Inner class for the Iterator to access the books list
    // This is a common way to implement ConcreteIterator
    private static class BookIterator implements Iterator<Book> {
        private final List<Book> bookList;
        private int position = 0;

        public BookIterator(List<Book> bookList) {
            this.bookList = bookList;
        }

        @Override
        public boolean hasNext() {
            return position < bookList.size() && bookList.get(position) != null;
        }

        @Override
        public Book next() {
            if (this.hasNext()) {
                return bookList.get(position++);
            }
            return null; // Or throw NoSuchElementException like java.util.Iterator
        }
    }
}

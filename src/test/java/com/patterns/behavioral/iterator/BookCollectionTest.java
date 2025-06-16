package com.patterns.behavioral.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookCollectionTest {
    private BookCollection collection;
    private Book book1;
    private Book book2;

    @BeforeEach
    void setUp() {
        collection = new BookCollection();
        book1 = new Book("Title1", "Author1", "ISBN1");
        book2 = new Book("Title2", "Author2", "ISBN2");
    }

    @Test
    void createIterator_onEmptyCollection_hasNextIsFalse() {
        Iterator<Book> iterator = collection.createIterator();
        assertFalse(iterator.hasNext());
    }

    @Test
    void createIterator_onEmptyCollection_nextReturnsNull() {
        Iterator<Book> iterator = collection.createIterator();
        assertNull(iterator.next()); // Or assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void createIterator_onNonEmptyCollection_iteratesCorrectly() {
        collection.addBook(book1);
        collection.addBook(book2);
        Iterator<Book> iterator = collection.createIterator();

        assertTrue(iterator.hasNext());
        assertSame(book1, iterator.next());

        assertTrue(iterator.hasNext());
        assertSame(book2, iterator.next());

        assertFalse(iterator.hasNext());
        assertNull(iterator.next()); // Or assertThrows
    }

    @Test
    void createIterator_multipleIterators_operateIndependently() {
        collection.addBook(book1);
        collection.addBook(book2);

        Iterator<Book> iter1 = collection.createIterator();
        Iterator<Book> iter2 = collection.createIterator();

        assertTrue(iter1.hasNext());
        assertSame(book1, iter1.next(), "Iter1 first element");

        assertTrue(iter2.hasNext());
        assertSame(book1, iter2.next(), "Iter2 first element should be same as Iter1 first");

        assertTrue(iter1.hasNext());
        assertSame(book2, iter1.next(), "Iter1 second element");

        assertTrue(iter2.hasNext());
        assertSame(book2, iter2.next(), "Iter2 second element should be same as Iter1 second");

        assertFalse(iter1.hasNext());
        assertFalse(iter2.hasNext());
    }

    @Test
    void addBook_increasesCount() {
        assertEquals(0, collection.getCount());
        collection.addBook(book1);
        assertEquals(1, collection.getCount());
        collection.addBook(book2);
        assertEquals(2, collection.getCount());
    }

    @Test
    void addBook_nullBook_doesNotIncreaseCount() {
        assertEquals(0, collection.getCount());
        collection.addBook(null);
        assertEquals(0, collection.getCount());
    }
}

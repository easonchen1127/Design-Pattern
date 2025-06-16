package com.patterns.behavioral.iterator;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class BookCollectionWithJavaIterableTest {
    @Test
    void iterate_usingEnhancedForLoop_iteratesCorrectly() {
        BookCollectionWithJavaIterable collection = new BookCollectionWithJavaIterable();
        Book book1 = new Book("Java Title 1", "Java Author 1", "ISBNJ1");
        Book book2 = new Book("Java Title 2", "Java Author 2", "ISBNJ2");
        collection.addBook(book1);
        collection.addBook(book2);

        List<Book> iteratedBooks = new ArrayList<>();
        for (Book book : collection) { // This uses the iterator() method implicitly
            iteratedBooks.add(book);
        }

        assertEquals(2, iteratedBooks.size());
        assertTrue(iteratedBooks.contains(book1));
        assertTrue(iteratedBooks.contains(book2));
    }
}

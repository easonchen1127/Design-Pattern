package com.patterns.behavioral.iterator;

// Iterator Interface
public interface Iterator<T> {
    boolean hasNext();
    T next();
    // Optional: void remove(); (java.util.Iterator has this)
}

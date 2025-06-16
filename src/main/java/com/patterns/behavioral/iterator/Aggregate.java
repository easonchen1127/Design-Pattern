package com.patterns.behavioral.iterator;

// Aggregate Interface
public interface Aggregate<T> {
    Iterator<T> createIterator();
}

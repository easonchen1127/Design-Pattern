package com.patterns.creational.factory;

public interface Document {
    void open();
    void save(String path);
    String getType();
}

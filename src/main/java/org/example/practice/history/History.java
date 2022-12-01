package org.example.practice.history;

import java.util.List;

public interface History<T> {

    T get(int index);
    void save(T data);

    List<T> getAll();
}

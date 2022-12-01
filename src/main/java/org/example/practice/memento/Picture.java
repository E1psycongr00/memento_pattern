package org.example.practice.memento;

// feature of originator
public interface Picture<T> {

    T getSnapShot();
    void setSnapShot(T snapShot);
}

package org.example.practice.car;

public class Car {

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move(int value) {
        moveCondition(value);
        this.position++;
    }

    private boolean moveCondition(int value) {
        return value >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

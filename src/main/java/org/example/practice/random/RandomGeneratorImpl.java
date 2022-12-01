package org.example.practice.random;

import java.util.Random;

public class RandomGeneratorImpl implements RandomGenerator {

    private final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }
}

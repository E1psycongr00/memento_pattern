package org.example.practice;

import java.util.List;
import org.example.practice.car.Car;
import org.example.practice.history.History;
import org.example.practice.history.RacingHistory;
import org.example.practice.simulator.CarSimulator;
import org.example.practice.simulator.CarSimulator.RacingSnapShot;

public class CarService {
    private final CarSimulator carSimulator = new CarSimulator();
    private final History<RacingSnapShot> history;

    public CarService(History<RacingSnapShot> history) {
        this.history = history;
    }

    public void createCar(List<Car> cars) {
        carSimulator.createCar(cars);
        history.save(carSimulator.getSnapShot());
    }

    public void simulate(int tryCount) {
        for (int i = 0; i < tryCount; ++i) {
            carSimulator.simulate();
            RacingSnapShot racingSnapShot = carSimulator.getSnapShot();
            history.save(racingSnapShot);
        }
    }

    //........
}

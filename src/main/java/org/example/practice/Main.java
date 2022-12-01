package org.example.practice;

import java.util.List;
import org.example.practice.car.Car;
import org.example.practice.history.History;
import org.example.practice.history.RacingHistory;
import org.example.practice.simulator.CarSimulator.RacingSnapShot;

public class Main {
    public static void main(String[] args) {
        History<RacingSnapShot> history = new RacingHistory();
        CarService carService = new CarService(history);
        List<Car> cars = List.of(new Car("페이커"), new Car("이렐킹"), new Car("하세기"));

        carService.createCar(cars);

        System.out.println(history.getAll());
        System.out.println();

        carService.simulate(5);
        history.getAll().forEach(System.out::println);
    }
}

package org.example.practice.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.example.practice.car.Car;
import org.example.practice.memento.Picture;
import org.example.practice.random.RandomGenerator;
import org.example.practice.random.RandomGeneratorImpl;
import org.example.practice.simulator.CarSimulator.RacingSnapShot;

public class CarSimulator implements Simulator, Picture<RacingSnapShot> {

    private final RandomGenerator randomGenerator = new RandomGeneratorImpl();

    private final List<Car> cars = new ArrayList<>();

    public void createCar(List<Car> cars) {
        this.cars.addAll(cars);
    }

    @Override
    public void simulate() {
        for (Car car : cars) {
            int number = randomGenerator.generate();
            car.move(number);
        }
    }

    @Override
    public RacingSnapShot getSnapShot() {
        return RacingSnapShot.makeRacingSnapShot(cars);
    }

    @Override
    public void setSnapShot(RacingSnapShot snapShot) {
        cars.clear();
        List<CarSnapShot> carSnapShots = snapShot.getCarSnapShots();
        carSnapShots.forEach(carSnapShot -> {
            this.cars.add(new Car(carSnapShot.getName(), carSnapShot.getPosition()));
        });
    }

    public static class RacingSnapShot {

        private final List<CarSnapShot> carSnapShots;

        private RacingSnapShot(List<CarSnapShot> carSnapShots) {
            this.carSnapShots = carSnapShots;
        }

        private static RacingSnapShot makeRacingSnapShot(List<Car> cars) {
            List<CarSnapShot> carSnapShots = cars.stream().map(CarSnapShot::makeCarSnapShot)
                    .collect(Collectors.toList());
            return new RacingSnapShot(carSnapShots);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            RacingSnapShot that = (RacingSnapShot) o;
            return Objects.equals(carSnapShots, that.carSnapShots);
        }

        @Override
        public int hashCode() {
            return Objects.hash(carSnapShots);
        }

        public List<CarSnapShot> getCarSnapShots() {
            return carSnapShots;
        }

        @Override
        public String toString() {
            return "RacingSnapShot{" +
                    "car=" + carSnapShots +
                    '}';
        }
    }

    public static class CarSnapShot {
        private final String name;
        private final int position;

        private CarSnapShot(String name, int position) {
            this.name = name;
            this.position = position;
        }

        private CarSnapShot(CarSnapShot carSnapShot) {
            this.name = carSnapShot.getName();
            this.position = carSnapShot.getPosition();
        }

        private static CarSnapShot makeCarSnapShot(Car car) {
            return new CarSnapShot(car.getName(), car.getPosition());
        }

        public String getName() {
            return name;
        }

        public int getPosition() {
            return position;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", position=" + position +
                    '}';
        }
    }
}

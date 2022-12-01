package org.example.practice.history;

import java.util.ArrayList;
import java.util.List;
import org.example.practice.simulator.CarSimulator.RacingSnapShot;

public class RacingHistory implements History<RacingSnapShot> {

    List<RacingSnapShot> history = new ArrayList<>();

    @Override
    public RacingSnapShot get(int turn) {
        return this.history.get(turn);
    }

    @Override
    public void save(RacingSnapShot data) {
        this.history.add(data);
    }

    @Override
    public List<RacingSnapShot> getAll() {
        return this.history;
    }
}

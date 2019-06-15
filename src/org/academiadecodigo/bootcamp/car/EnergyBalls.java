package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public class EnergyBalls extends Obstacle {

    public EnergyBalls(GridPosition pos) {
        super(pos);
    }

    //see move() in obstacle
    @Override
    public void move() {

        accelerate();

    }
}

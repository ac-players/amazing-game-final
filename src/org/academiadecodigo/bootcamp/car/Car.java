package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public class Car extends Obstacle {

    public Car(GridPosition pos) {
        super(pos, ObstacleType.CAR);
    }

    //see move() in obstacle
    @Override
    public void move() {

        accelerate();

    }
}

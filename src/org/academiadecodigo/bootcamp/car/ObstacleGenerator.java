package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.Grid;

//A factory of objects
public class ObstacleGenerator {

    //returns a new obstacle
    public static Obstacle getNewCar(Grid grid) {

        Obstacle obstacle = new Car(grid.makeGridPosition((int)(Math.random() * grid.getCols()- 1), 0,(int) ((Math.random()*3)+1)));

        return obstacle;

    }

}

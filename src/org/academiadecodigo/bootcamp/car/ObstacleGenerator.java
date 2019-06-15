package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.Grid;

//A factory of objects
public class ObstacleGenerator {

    //returns a new obstacle
    public static Obstacle getEnergyBalls(Grid grid) {


        Obstacle obstacle = new EnergyBalls(grid.makeGridPosition((int)(Math.random() * grid.getCols()- 1), 1,1));
        return obstacle;

    }

}

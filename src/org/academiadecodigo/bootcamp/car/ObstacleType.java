package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.GridColor;

//Different types of obstacles
public enum ObstacleType {

    CAR(GridColor.BLUE),
    PLAYER(GridColor.MAGENTA);

    private GridColor color;

    //Constructor of Obstacle Types
    ObstacleType(GridColor color) {
        this.color = color;
    }

    //Obtain the getColor associated with each car type
    public GridColor getColor() {

        return this.color;

    }
}

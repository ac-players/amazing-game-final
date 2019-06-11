package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

//Generic Obstacle, should be extended
abstract public class Obstacle {

    private GridPosition pos;
    private Grid grid;
    private ObstacleType obstacleType;

    // Allow direct access from subclasses
    protected CollisionDetector collisionDetector;
    protected GridDirection currentDirection;

    //constructs a new obstacle
    public Obstacle(GridPosition pos, ObstacleType obstacleType) {

        this.pos = pos;
        this.obstacleType = obstacleType;

        pos.setColor(obstacleType.getColor());
        currentDirection = GridDirection.DOWN;

    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public GridPosition getPos() {
        return pos;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    //Perform specific moving behaviour according to the obstacle type
    abstract public void move();


    //Chooses a new direction for the car

    /*
    public GridDirection chooseDirection() {


        // Let's move in the same direction by default
        GridDirection newDirection = currentDirection;

        // Sometimes, we want to change direction...
        if (Math.random() > ((double) directionChangeLevel) / 10) {
            newDirection = GridDirection.values()[(int) (Math.random() * GridDirection.values().length)];

            // but we do not want to perform U turns..
            if (newDirection.isOpposite(currentDirection)) {
                return chooseDirection();
            }
        }

        return newDirection;

    }
    */

    // accelarates the object towards the player
    public void accelerate() {
        if (isInLastRow()) {
            pos.hide();

            
            if(Math.random() < 0.6){
                getPos().setPos((int)(Math.random() * grid.getCols()), -1);
                pos.show();
            }
        }

        // Accelerate


        getPos().moveInDirection(GridDirection.DOWN, 1);
    }

    //detects if the obstacle is in the last row
    public boolean isInLastRow() {


            if (getPos().getRow() == grid.getRows() - 1) {
                return true;
            }

        return false;
    }

}


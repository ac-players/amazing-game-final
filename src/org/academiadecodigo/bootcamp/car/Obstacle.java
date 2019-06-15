package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.CollisionDetector;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

//Generic Obstacle, should be extended
abstract public class Obstacle {

    private GridPosition pos;
    private Grid grid;


    // Allow direct access from subclasses
    protected CollisionDetector collisionDetector;
    protected GridDirection currentDirection;

    //constructs a new obstacle
    public Obstacle(GridPosition pos) {

        this.pos = pos;



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




    // accelarates the object towards the player
    public void accelerate() {
        if (isInLastRow()) {
            pos.hide();

            
            if(Math.random() < 0.6){
                getPos().setPos((int)(Math.random() * grid.getCols()), 0);
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


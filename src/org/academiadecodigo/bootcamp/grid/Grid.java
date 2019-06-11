package org.academiadecodigo.bootcamp.grid;

import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public interface Grid {


    //Initializes the grid

    public void init();


    //Gets the number of columns in the grid

    public int getCols();


    //Gets the number of rows in the grid

    public int getRows();


    //Create a random grid position

    public GridPosition makeGridPosition();


    //Creates a a grid position in a specific column and row

    GridPosition makeGridPosition(int col, int row, int type);

    public GridPosition makeGridPosition(int col, int row);

}

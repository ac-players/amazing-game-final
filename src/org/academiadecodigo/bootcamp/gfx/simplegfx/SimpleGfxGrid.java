package org.academiadecodigo.bootcamp.gfx.simplegfx;

import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.awt.*;

public class SimpleGfxGrid implements Grid {

    private int cols;
    private int rows;
    private int x;
    private int y;
    private int cellSize = 45;
    private Rectangle grid;
    private Picture grid2;

    public static final int PADDING = 10;

    public SimpleGfxGrid(int cols, int rows){

        this.cols = cols;
        this.rows = rows;
    }

    /**
     * @see Grid#init()
     */
    @Override
    public void init() {

        grid = new Rectangle(getX()+PADDING, getY()+PADDING, cols*cellSize, rows*cellSize);
        grid2 = new Picture(getX(),getY(),"/Users/codecadet/Desktop/amazing game project/amazing game goku/resources/tunnel_road.jpg");
        grid2.grow (65, 300);
        grid2.translate (60,0);



        grid.draw();
        grid2.draw();
    }

    /**
     * @see Grid#getCols()
     */
    @Override
    public int getCols() { return cols; }

    /**
     * @see Grid#getRows()
     */
    @Override
    public int getRows() { return rows; }

    /**
     * Obtains the width of the grid in pixels
     * @return the width of the grid
     */
    public int getWidth() { return cols*cellSize; }

    /**
     * Obtains the height of the grid in pixels
     * @return the height of the grid
     */
    public int getHeight() {
        return rows*cellSize;
    }

    /**
     * Obtains the grid X position in the SimpleGFX canvas
     * @return the x position of the grid
     */
    public int getX() {
        return PADDING;
    }

    /**
     * Obtains the grid Y position in the SimpleGFX canvas
     * @return the y position of the grid
     */
    public int getY() {
        return PADDING;
    }

    /**
     * Obtains the pixel width and height of a grid position
     * @return
     */
    public int getCellSize() {
        return cellSize;
    }

    /**
     * @see Grid#makeGridPosition()
     */
    @Override
    public GridPosition makeGridPosition() {
        SimpleGfxGridPosition gridPosition = new SimpleGfxGridPosition((int)(Math.random()*cols + 1), (int)(Math.random()*rows), this,0);
        return gridPosition;
    }

    /**
     * @see Grid#makeGridPosition(int, int)
     */
    @Override

    public GridPosition makeGridPosition(int col, int row, int type) {

        SimpleGfxGridPosition gridPosition = new SimpleGfxGridPosition(col+ 1, row, this,type);
        return gridPosition;
    }

    @Override
    public GridPosition makeGridPosition(int col, int row) {

        SimpleGfxGridPosition gridPosition = new SimpleGfxGridPosition(col, row, this);
        return gridPosition;
    }

    /**
     * Auxiliary method to compute the y value that corresponds to a specific row
     * @param row index
     * @return y pixel value
     */
    public int rowToY(int row) { return (row * cellSize) + PADDING; }

    /**
     * Auxiliary method to compute the x value that corresponds to a specific column
     * @param column index
     * @return x pixel value
     */
    public int columnToX(int column) { return (column * cellSize) + PADDING;
    }
}

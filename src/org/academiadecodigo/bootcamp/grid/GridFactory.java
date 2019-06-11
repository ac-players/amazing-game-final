package org.academiadecodigo.bootcamp.grid;
import org.academiadecodigo.bootcamp.gfx.simplegfx.SimpleGfxGrid;

public class GridFactory {


    //Creates a new grid

    public static Grid makeGrid(int cols, int rows) {

        return new SimpleGfxGrid(cols, rows);

    }

}

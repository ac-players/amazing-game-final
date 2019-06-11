package org.academiadecodigo.bootcamp.car;
import org.academiadecodigo.bootcamp.Game;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler{

    private GridPosition pos;
    private Grid grid;
    private ObstacleType obstacleType = ObstacleType.PLAYER;
    private boolean crashed = false; // the car crashed state

    public boolean isCrashed() {
        return crashed;
    }

    public Player(Grid grid, GridPosition pos) {

        this.pos = pos;
        this.obstacleType = obstacleType;

        pos.setColor(obstacleType.getColor());
    }

    public GridPosition getPos() {
        return pos;
    }

    public void crash(){
        crashed = true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (crashed) { return; }

        int key = keyboardEvent.getKey();

        switch(key){

            case KeyboardEvent.KEY_LEFT:
                pos.moveInDirection(GridDirection.LEFT, 1);
                break;
            case KeyboardEvent.KEY_RIGHT:
                pos.moveInDirection(GridDirection.RIGHT, 1);
                break;
            case KeyboardEvent.KEY_UP:
                pos.moveInDirection(GridDirection.UP, 1);
                break;
            case KeyboardEvent.KEY_DOWN:
                pos.moveInDirection(GridDirection.DOWN, 1);
                break;
            default:
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) { }

    public void move(){

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);



    }
}

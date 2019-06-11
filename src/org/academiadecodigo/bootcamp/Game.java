package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.Obstacle;
import org.academiadecodigo.bootcamp.car.ObstacleGenerator;
import org.academiadecodigo.bootcamp.car.Player;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridFactory;


//The game logic
public class Game {


    //Graphical Obstacle field
    private Grid grid;

    //Container of Cars
    private Obstacle[] obstacles;
    private Player player;

    //Animation delay
    private int delay;


    private CollisionDetector collisionDetector;

    public Obstacle[] getObstacles() {
        return obstacles;
    }

    //Constructs a new game

    Game(int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(cols, rows);
        this.delay = delay;


    }




    public void init() {



        grid.init();

        //player = new Player(grid, (grid.makeGridPosition(grid.getCols()/2, grid.getRows()-2)));
        player = new Player(grid, (grid.makeGridPosition(grid.getCols()/2, grid.getRows()-2, 0)));

        obstacles = new Obstacle[grid.getCols()+6];
        collisionDetector = new CollisionDetector(obstacles, player);
    
        for (int i = 0; i < obstacles.length; i++) {

            obstacles[i] = ObstacleGenerator.getNewCar(grid);
            obstacles[i].setCollisionDetector(collisionDetector);
            obstacles[i].setGrid(grid);

        }
    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {
        String filepath = "/Users/codecadet/Desktop/amazing game project/amazing game goku/resources/y2mate.com - dragon_ball_super_soundtrack_full_ultimate_battle_akira_kushida_lyrics_cc_GH9u4eZQGk8.wav";

        musicStuff musicObject  = new musicStuff();
        musicObject.playMusic(filepath);
        player.move();

        while (!player.isCrashed()) {

            // Pause for a while
            Thread.sleep(delay);

            moveAllCars();

        }
        musicObject.stopMusic(musicObject);
    }

    /**
     * Moves all obstacles
     */
    public void moveAllCars() {

        for (Obstacle o : obstacles) {

            collisionDetector.check(o, player);

            o.move();

            collisionDetector.check(o, player);
        }

    }



}

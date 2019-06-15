package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.Obstacle;
import org.academiadecodigo.bootcamp.car.ObstacleGenerator;
import org.academiadecodigo.bootcamp.car.Player;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.GridFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;


//The game logic
public class Game {


    //Graphical Obstacle field
    private Grid grid;

    //Container of Cars
    private Obstacle[] obstacles;
    private Player player;
    private Picture enemy;

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




    public void init() throws InterruptedException {



        grid.init();


        player = new Player(grid, (grid.makeGridPosition(grid.getCols()/2, grid.getRows()-2, 0)));

        obstacles = new Obstacle[grid.getCols()+6];
        collisionDetector = new CollisionDetector(obstacles, player);
    
        for (int i = 0; i < obstacles.length; i++) {

            obstacles[i] = ObstacleGenerator.getEnergyBalls(grid);
            obstacles[i].setCollisionDetector(collisionDetector);
            obstacles[i].setGrid(grid);

        }

        Picture gameStart = new Picture(45, 100, "GameStart.png");
        gameStart.grow(-32, -32);
        gameStart.draw();
        Thread.sleep(3000, 1000);
        gameStart.delete();
    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        Audio musicObject  = new Audio();
        musicObject.runAudio();
        player.move();

        while (!player.isCrashed()) {

              enemy = new Picture((int) ((((Math.random()) * grid.getCols() * 75))-300), 1, "buu embruxado.png");
                enemy.draw();

            // Pause for a while
            Thread.sleep(delay);

            moveAllCars();
            enemy.delete();
        }
        
        Thread.sleep(500,1000);
        musicObject.stopAudio();
        Picture gameOver = new Picture(45, 100, "GameOver.png");
        gameOver.draw();
    }

    /**
     * Moves all obstacles
     */
    public void moveAllCars() throws InterruptedException {

        for (Obstacle o : obstacles) {

            collisionDetector.check(o, player);

            o.move();

            collisionDetector.check(o, player);
        }

    }



}

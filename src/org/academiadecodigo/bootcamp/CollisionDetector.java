package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.Obstacle;
import org.academiadecodigo.bootcamp.car.Player;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    private Obstacle[] obstacles;
    private Player player;

    public CollisionDetector(Obstacle[] obstacles, Player player) {

        this.obstacles = obstacles;
        this.player = player;
    }

    public boolean isUnSafe(GridPosition pos) {

        for (Obstacle c : obstacles) {

            if (c.getPos()!= pos && c.getPos().equals(pos)) {
                return true;
            }

        }

        return false;

    }

    //Checks for collisions with specific obstacle

    public void check(Obstacle obstacle, Player player)  {

        for (Obstacle ic : obstacles) {

            if (ic.getPos().equals(player.getPos())) {
                Picture explosion = new Picture (player.getPos().getCol()*55, player.getPos().getRow()*55, "explosion.png");
                Audio explosionSound = new Audio();
                explosionSound.explosionSound();
                explosion.draw();

                player.crash();
            }

        }

    }

}

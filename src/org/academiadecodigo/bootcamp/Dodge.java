package org.academiadecodigo.bootcamp;


public class Dodge {

    public static void main(String[] args) {
        try {
            Game g = new Game(14, 16, 140);

            g.init();
            g.start();


        } catch (Exception e) {
            System.out.println("We are bad at programming");
        }

    }
}
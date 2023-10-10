package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            new Game(new Player(30, 20, 7, 8, 12, 3, "игрок"),
                    new Monster(10, 10, 9, 4, 3, 2, "зомби"),
                    new Monster(15, 15, 3, 9, 4, 0, "призрак"),
                    new Monster(22, 22, 11, 2, 5, 1, "паук")
            ).start();
        } catch (IllegalArgumentException e){
            System.out.println("указаны некорректные начальные параметры");
        }
    }
}
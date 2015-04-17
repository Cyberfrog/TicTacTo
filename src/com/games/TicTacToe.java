package com.games;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        System.out.println(Game.getBanner());
       do {
           System.out.println("\nEnter Position:");
           if (!game.playAt(scanner.nextInt())) {
               System.out.println("can not play at Position");
           }
           System.out.println(game.getState());
       } while (!game.isFinished());
    }
}

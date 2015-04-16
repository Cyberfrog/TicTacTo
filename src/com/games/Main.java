package com.games;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game g1 = new Game();
        Scanner s =new Scanner(System.in);
        System.out.println(Game.getBanner());
       do {
           System.out.println("\nEnter Position:");
           if (!g1.playAt(s.nextInt())) {
               System.out.println("can not play at Position");
           }
           ;
            System.out.println(g1.getState());
       } while (g1.isNotFinished());
    }
}

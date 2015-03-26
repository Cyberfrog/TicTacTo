package com.games;

/**
 * Created by gauravd on 3/21/2015.
 */
public class Player {
    private char mark;

    public Player(char mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Player{"+mark+"}";
    }

    public char getMark() {
        return mark;
    }
}

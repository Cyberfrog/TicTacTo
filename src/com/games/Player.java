package com.games;

public class Player {
    private Signiture mark;

    public Player(Signiture mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Player{"+mark+"}";
    }

    public Signiture getMark() {
        return mark;
    }
}

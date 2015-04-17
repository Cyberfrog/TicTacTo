package com.games;

public class Player {
    private Signiture mark;

    public Player(Signiture mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return mark == player.mark;

    }

    @Override
    public int hashCode() {
        return mark.hashCode();
    }

    @Override
    public String toString() {
        return "Player{"+mark+"}";
    }

    public Signiture getMark() {
        return mark;
    }

}

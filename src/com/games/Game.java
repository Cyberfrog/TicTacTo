package com.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gauravd on 3/21/2015.
 */
public class Game {
    private Player turn;
    private final Player p1;
    private final Player p2;
    private final Bord bord;
    private static final List<List<Integer>> winigPositions = getWiningPositions();


    public Game() {
        p1 = new Player('X');
        p2 = new Player('O');
        turn = p1;
        bord = new Bord();
    }

    public String getState() {
        if (hasWon(lastTurn())) {
            return  bord.toString()+"Winner : " + lastTurn();
        }
        if (isOver()) {
            return "Game Over :\n" + bord.toString();
        }

        return "Turn: " + turn + "\n"
                + bord.toString();
    }

    private Player lastTurn() {
        return turn.equals(p1) ? p2 : p1;
    }

    private boolean hasWon(Player player) {
        List<Integer> positions = bord.getAllPositions(lastTurn().getMark());
        for (List<Integer> winigPosition : winigPositions) {
            if (positions.containsAll(winigPosition)) {
                return true;
            }
        }
        return false;
    }

    private static List<List<Integer>> getWiningPositions() {
        List<List<Integer>> winigPositions = new ArrayList<List<Integer>>();
        Integer a[] = {1, 2, 3};
        Integer b[] = {4, 5, 6};
        Integer c[] = {7, 8, 9};
        Integer d[] = {1, 4, 7};
        Integer e[] = {2, 5, 8};
        Integer f[] = {3, 6, 9};
        Integer g[] = {1, 5, 9};
        Integer h[] = {3, 5, 7};
        winigPositions.add(Arrays.asList(a));
        winigPositions.add(Arrays.asList(b));
        winigPositions.add(Arrays.asList(c));
        winigPositions.add(Arrays.asList(d));
        winigPositions.add(Arrays.asList(e));
        winigPositions.add(Arrays.asList(f));
        winigPositions.add(Arrays.asList(g));
        winigPositions.add(Arrays.asList(h));
        return winigPositions;
    }

    private boolean isOver() {
        return bord.isFilled();
    }

    public boolean isFinished() {
        return isOver() || hasWon(lastTurn());
    }

    public String whosTurn() {
        return turn.toString();
    }

    public void playAt(int position) {
        if(bord.isPositionAllowed(position)){
            bord.putMarkAt(position, turn.getMark());
            ChangeTurn();
            return ;
        }
        System.out.println("can not play at Position");
    }

    private void ChangeTurn() {
        turn = turn.equals(p1) ? p2 : p1;
    }
    public  static String getBanner(){
        return "*******************\n" +
                "* Tic - Tac - Toe *\n" +
                "*******************\n"+Bord.PositionHelp();
    }
}

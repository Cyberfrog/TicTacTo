package com.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Game {
    private static final List<List<Integer>> winigPositions = getWiningPositions();
    private final Player playerX;
    private final Player playerO;
    private final Board board;
    private Player currentPlayer;


    public Game() {
        playerX = new Player(Signiture.X);
        playerO = new Player(Signiture.O);
        currentPlayer = playerX;
        board = new Board();
    }

    // move it to  constant class
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

    public static String getBanner() {
        return "*******************\n" +
                "* Tic - Tac - Toe *\n" +
                "*******************\n" + Board.PositionHelp();
    }

    public String getState() {
        if (hasWon(lastTurn())) {
            return board.toString() + "Winner : " + lastTurn();
        }
        if (isOver()) {
            return board.toString() + "Game Over :\n";
        }

        return board.toString() + "Turn: " + currentPlayer;
    }

    private Player lastTurn() {
        return currentPlayer.equals(playerX) ? playerO : playerX;
    }

    private boolean hasWon(Player player) {
        List<Integer> positions = board.getAllPositions(player.getMark());
        for (List<Integer> winigPosition : winigPositions) {
            if (positions.containsAll(winigPosition)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOver() {
        return board.isFilled();
    }

    public boolean isFinished() {
        return isOver() || hasWon(lastTurn());
    }

    public Player whosTurn() {
        return currentPlayer;
    }

    public boolean playAt(int position) {
        return putMark(position) && ChangeTurn();
    }

    private boolean putMark(int position) {
        if (board.isPositionAllowed(position)) {
            board.putMarkAt(position, currentPlayer.getMark());
        return true;
        }
        return false;
    }
//return player will make it teastable

    private boolean ChangeTurn() {
        currentPlayer = currentPlayer.equals(playerX) ? playerO : playerX;
        return !currentPlayer.equals(lastTurn());
    }
}

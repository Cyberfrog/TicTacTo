package com.games;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by gauravd on 3/21/2015.
 */
public class GameTest {
    @Test
    public void test_GameFirstTurnIsOfPlayerOne() {
        Game g1 = new Game();
        Player p = g1.whosTurn();
        assertEquals(new Player(Signiture.X), p);
    }

    @Test
    public void test_GamePutsMarkOfPlayerWhosTurn() throws IOException {
        Game g1 = new Game();
        g1.playAt(3);
        BoardTest.equalsFile("gameStateChanged", g1.getState());
    }
    @Test
    public void test_GameInitialIsBlank() throws IOException {
        Game g1 = new Game();
        BoardTest.equalsFile("NewGameState", g1.getState());
    }

    @Test
    public void test_playAt_changes_Turn_afterPlaying(){
        Game g1 = new Game();
        g1.playAt(3);
        assertEquals(new Player(Signiture.O), g1.whosTurn());
    }

    @Test
    public void test_GameOverStatus() throws IOException {
        Game g1 = new Game();
        g1.playAt(1);
        g1.playAt(2);
        g1.playAt(3);
        g1.playAt(4);
        g1.playAt(5);
        g1.playAt(7);
        g1.playAt(6);
        g1.playAt(9);
        g1.playAt(8);
        BoardTest.equalsFile("GameOverState", g1.getState());
    }
    @Test
    public void test_game_isFinished_on_GameOver_() throws IOException {
        Game g1 = new Game();
        g1.playAt(1);
        g1.playAt(2);
        g1.playAt(3);
        g1.playAt(4);
        g1.playAt(5);
        g1.playAt(7);
        g1.playAt(6);
        g1.playAt(9);
        g1.playAt(8);
        assertTrue(g1.isFinished());
    }@Test
    public void test_WiningststusOnListMoveWin() throws IOException {
        Game g1 = new Game();
        g1.playAt(1);
        g1.playAt(2);
        g1.playAt(4);
        g1.playAt(5);
        g1.playAt(3);
        g1.playAt(6);
        g1.playAt(8);
        g1.playAt(9);
        g1.playAt(7);
        BoardTest.equalsFile("GameWinOnLastMove", g1.getState());
    }
    @Test
    public void test_GameWinStatus() throws IOException {
        Game g1 = new Game();
        g1.playAt(1);
        g1.playAt(2);
        g1.playAt(3);
        g1.playAt(4);
        g1.playAt(5);
        g1.playAt(6);
        g1.playAt(7);
        BoardTest.equalsFile("GameWinState", g1.getState());
    }
    @Test
    public void test_gameIsFinished_if_gameHasWon() throws IOException {
        Game g1 = new Game();
        g1.playAt(1);
        g1.playAt(2);
        g1.playAt(3);
        g1.playAt(4);
        g1.playAt(5);
        g1.playAt(6);
        g1.playAt(7);
        assertTrue(g1.isFinished());
    }
    @Test
    public void test_initialy_game_isNotFinished() throws IOException {
        Game g1 = new Game();
        assertFalse(g1.isFinished());
    }
    @Test
    public void test_GameBanner() throws IOException {
        BoardTest.equalsFile("GameBanner", Game.getBanner());
    }

    @Test
    public void test_playAt_returns_true_on_SuccessFull_Marking() {
        Game g1 = new Game();
        assertTrue(g1.playAt(2));

    }

    @Test
    public void test_playAt_returns_False_on_UnSuccessFull_Marking() {
        Game g1 = new Game();
        g1.playAt(2);
        assertFalse(g1.playAt(2));

    }
}

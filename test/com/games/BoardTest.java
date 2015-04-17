package com.games;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.*;

/**
 * Created by gauravd on 3/21/2015.
 */
public class BoardTest {
    private static final String GOLD_PATH = "test/data";

    public static void equalsFile(String fileName, String actualValue) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        String thisFileLine;
        int i = 0;
        while ((thisFileLine = file.readLine()) != null) {
            i++;
            String message = "in file:" + fileName + "At :" + i;
            assertEquals(message, thisFileLine, actualStream.readLine());
        }
    }

    @Test
    public void test_bordIsAbletoPutMarkOnItsCell() throws IOException {
        Board b = new Board();
        b.putMarkAt(2, Signiture.X);
        equalsFile("filledBord", b.toString());
    }

    @Test
    public void test_alreadyMarkPositionIsNotAllowed() throws IOException {
        Board b = new Board();
        assertTrue(b.isPositionAllowed(2));

        b.putMarkAt(2, Signiture.X);
        assertFalse(b.isPositionAllowed(2));
    }

    @Test
    public void test_newBordIsBlank() throws IOException {
        Board b = new Board();
        equalsFile("BlankBord", b.toString());
    }

    @Test
    public void test_isFilledReturnsFalseIfWholeBordIsNotFilled() throws IOException {
        Board b = new Board();
        b.putMarkAt(1, Signiture.X);
        b.putMarkAt(8, Signiture.X);
        b.putMarkAt(9, Signiture.X);
        assertFalse(b.isFilled());
    }

    @Test
    public void test_isFilledReturnsTrueIfWholeBordIsFilled() throws IOException {
        Board b = new Board();
        b.putMarkAt(1, Signiture.X);
        b.putMarkAt(2, Signiture.X);
        b.putMarkAt(3, Signiture.X);
        b.putMarkAt(4, Signiture.X);
        b.putMarkAt(5, Signiture.X);
        b.putMarkAt(6, Signiture.X);
        b.putMarkAt(7, Signiture.X);
        b.putMarkAt(8, Signiture.X);
        b.putMarkAt(9, Signiture.X);
        assertTrue(b.isFilled());
    }
}

package com.games;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by gauravd on 3/21/2015.
 */
public class BordTest {
    private static final String GOLD_PATH = "test/data";

    @Test
    public void test_bordIsAbletoPutMarkOnItsCell() throws IOException {
        Bord b = new Bord();
        b.putMarkAt(2,'X');
        equalsFile("Bord String", "filledBord", b.toString());
    }
    @Test
    public void test_alreadyMarkPositionIsNotAllowed() throws IOException {
        Bord b = new Bord();
       assertTrue(b.isPositionAllowed(2));
        b.putMarkAt(2,'X');
        assertFalse( b.isPositionAllowed(2));
    }
    @Test
    public void test_newBordIsBlank() throws IOException {
        Bord b = new Bord();
        equalsFile("BlankBord String", "BlankBord", b.toString());
    }
    @Test
    public void test_isFilledReturnsFalseIfWholeBordIsNotFilled() throws IOException {
        Bord b = new Bord();
        b.putMarkAt(1,'X');
        b.putMarkAt(8,'X');
        b.putMarkAt(9,'X');
        assertFalse(b.isFilled());
    }
    @Test
    public void test_isFilledReturnsTrueIfWholeBordIsFilled() throws IOException {
        Bord b = new Bord();
        b.putMarkAt(1,'X');
        b.putMarkAt(2,'X');
        b.putMarkAt(3,'X');
        b.putMarkAt(4,'X');
        b.putMarkAt(5,'X');
        b.putMarkAt(6,'X');
        b.putMarkAt(7,'X');
        b.putMarkAt(8,'X');
        b.putMarkAt(9,'X');
        assertTrue(b.isFilled());
    }
   public static void equalsFile(String message, String fileName, String actualValue) throws IOException {
        BufferedReader file = new BufferedReader (new FileReader(GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader (new StringReader(actualValue));
        String thisFileLine = null;
        int i=0;
        while  ((thisFileLine = file.readLine()) != null) {
            i++;
            assertEquals ("in file:" + fileName+"At :"+i, thisFileLine, actualStream.readLine());
        }
    }
}

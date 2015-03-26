package com.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gauravd on 3/21/2015.
 */
public class Bord {
    char cells[] =new char[9];

    public Bord() {
        Arrays.fill(cells, '-');
    }

    public void putMarkAt(int position, char mark) {
        cells[position-1] = mark;
    }

    @Override
    public String toString() {
        String result="0 1 2\n3 4 5\n6 7 8\n";
        for (int i =0 ;i<cells.length;i++) {
            result = result.replace(Character.forDigit(i,10),cells[i]);
        }
        return result;
    }


    public boolean isFilled() {
        return !(toString().contains("-"));
    }

    public List<Integer> getAllPositions(char mark) {
        List<Integer> position =  new ArrayList<Integer>();
        for (int i=0;i<cells.length;i++) {
            if(cells[i]==mark){
                position.add(i+1);
            }
        }
        return position;
    }

    public static String PositionHelp() {
        return "Board Positions\n" +
                "1 2 3\n" +
                "4 5 6\n" +
                "7 8 9\n";
    }

    public boolean isPositionAllowed(int position) {
        if(position>0&&position<=9){
            if(cells[position-1]=='-') return  true;
        }
        return  false;
    }
}

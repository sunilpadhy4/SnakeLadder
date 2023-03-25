package com.example.snakeladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
   private ArrayList<Pair<Integer,Integer>>positionCoordinates;

   private ArrayList<Integer>snakeLadder;

    public Board(){
        populatePositionCoordinates();
        setSnakeLadder();
    }
    private void populatePositionCoordinates(){
        positionCoordinates=new ArrayList();
        positionCoordinates.add(new Pair<>(0,0));
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                //x-axis
                int xCord =0;
                if(i%2==0){
                    xCord=j*SnakeLadder.tileSize + SnakeLadder.tileSize/2;
                }
                else{
                    xCord=SnakeLadder.height*SnakeLadder.tileSize-j*SnakeLadder.tileSize-SnakeLadder.tileSize/2;
                }
                //y-axis
                int yCord=SnakeLadder.height*SnakeLadder.tileSize-i*SnakeLadder.tileSize-SnakeLadder.tileSize/2;

                positionCoordinates.add(new Pair<>(xCord,yCord));

            }
        }
    }


    private void setSnakeLadder(){
        snakeLadder = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadder.add(i);
        }
        snakeLadder.set(4,25);
        snakeLadder.set(13,46);
        snakeLadder.set(27,5);
        snakeLadder.set(40,3);
        snakeLadder.set(33,49);
        snakeLadder.set(42,63);
        snakeLadder.set(43,18);
        snakeLadder.set(49,33);
        snakeLadder.set(50,66);

    }
    public int getXCoordinate(int position){
        if(position>0 && position<=100){
            return positionCoordinates.get(position).getKey();
        }
        return -1;
    }
    public int getYCoordinate(int position){
        if(position>0 && position<=100){
            return positionCoordinates.get(position).getValue();
        }
        return -1;
    }

    public int getSnakeLadder(int position){
        return snakeLadder.get(position);
    }

    public static void main(String[] args) {
        Board board = new Board();

        for (int i = 0; i < board.positionCoordinates.size(); i++) {
            System.out.println(i + " $ X : " + board.positionCoordinates.get(i).getKey()
                                    + " y : " + board.positionCoordinates.get(i).getValue());
        }
    }
}

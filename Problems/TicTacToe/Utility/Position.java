package Utility;

public class Position{
    private int r;
    private int c;

    public Position(int r,int c){
        this.r = r;
        this.c = c;
    }

    public int getRow(){
        return this.r;
    }

    public int getCol(){
        return this.c;
    }
};
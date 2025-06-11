package Utility;

import CommonEnum.Symbol;

public class Board{

    private int n;
    private Symbol[][] grid;
    private int totalCell;

    public Board(int n){
        this.n = n;
        this.grid = new Symbol[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                this.grid[i][j] = Symbol.EMPTY;
            }
        }

        this.totalCell = n * n;
    }

    public boolean isValidMove(Position pos){

        int r = pos.getRow();
        int c = pos.getCol();

        if(r < 0 || c < 0 || r >= n || c >= n || this.grid[r][c] != Symbol.EMPTY){
            return false;
        }
        return true;
    }

    public void makeMove(Position pos,Symbol symbol){

        int r = pos.getRow();
        int c = pos.getCol();

        this.grid[r][c] = symbol;
        this.totalCell -= 1;
    }

    public void printGrid(){

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(this.grid[i][j] == Symbol.X){
                    System.out.print("X ");
                }
                else if(this.grid[i][j] == Symbol.O){
                    System.out.print("O ");
                }
                else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public boolean isWinningLine(Position pos,Symbol symbol){

        int r = pos.getRow();
        int c = pos.getCol();
        boolean flag = true;

        // check row
        for(int i=0;i<this.n;i++){
            if(this.grid[r][i] != symbol){
                flag = false;
                break;
            }
        }
        if(flag) return true;

        flag = true;
        // check col
        for(int i=0;i<this.n;i++){
            if(this.grid[i][c] != symbol){
                flag = false;
                break;
            }
        }
        if(flag) return true;

        flag = true;
        // check left diagonal
        for(int i=0;i<this.n;i++){
            if(this.grid[i][i] != symbol){
                flag = false;
                break;
            }
        }
        if(flag) return true;

        flag = true;
        // check right diagonal
        for(int i=0, j=n-1;i < n && j >= 0; i++,j--){
            if(this.grid[i][j] != symbol){
                flag = false;
                break;
            }
        }

        return flag;
    }

    public boolean isDrawState(){
        return this.totalCell != 0;
    }
};
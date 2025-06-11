package Utility;

import PieceFactoryPackage.PieceFactory;

// Singleton Pattern

public class Board{

    private static Board instance;
    private Cell[][] board;

    private Board(int rows){
        initializeBoard(rows);
    }

    public static Board getInstance(int rows){
        if(instance == null){
            instance = new Board(rows);
        }
        return instance;
    }

    public void initializeBoard(int rows){

        this.board = new Cell[rows][rows];

        setPieceRow(0,true);
        setPawnRow(1,rows,true);

        setPieceRow(rows-1,false);
        setPawnRow(rows-2,rows,false);

        // other cells
        for(int i=2;i<rows-2;i++){
            for(int j=0;j<rows;j++){
                this.board[i][j] = new Cell(i,j,null);
            }
        }
    }

    public void setPieceRow(int row,boolean isWhite){

        this.board[row][0] =  new Cell(row,0,PieceFactory.createPiece("bishop",isWhite));
        this.board[row][1] =  new Cell(row,1,PieceFactory.createPiece("knight",isWhite));
        this.board[row][2] =  new Cell(row,2,PieceFactory.createPiece("rook",isWhite));
        this.board[row][3] =  new Cell(row,3,PieceFactory.createPiece("queen",isWhite));
        this.board[row][4] =  new Cell(row,4,PieceFactory.createPiece("king",isWhite));
        this.board[row][5] =  new Cell(row,5,PieceFactory.createPiece("rook",isWhite));
        this.board[row][6] =  new Cell(row,6,PieceFactory.createPiece("knight",isWhite));
        this.board[row][7] =  new Cell(row,7,PieceFactory.createPiece("bishop",isWhite));
    }

    public void setPawnRow(int row,int rows,boolean isWhite){
        for(int i=0;i<rows;i++){
            this.board[row][i] = new Cell(row,i,PieceFactory.createPiece("pawn",isWhite));
        }
    }

    public Cell getCell(int row,int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board.length){
            return this.board[row][col];
        }
        return null;
    }
};
package Controller;

import Utility.*;
import PieceFactoryPackage.Piece;
import CommonEnum.Status;
import PieceFactoryPackage.ConcretePieces.King;

import java.util.Scanner;

public class Chess{

    private Board board;
    private Player player1; // assuming White
    private Player player2; // assuming black
    boolean isWhiteTurn;
    private Player currPlayer;
    private Status status;

    public Chess(int rows,Player player1,Player player2){
        this.board = Board.getInstance(rows);
        this.player1 = player1;
        this.player2 = player2;
        this.isWhiteTurn = true;
        this.currPlayer = player1;
        this.status = Status.ACTIVE;
    }

    public void start(){

        Scanner scanner = new Scanner(System.in);

        while(this.status == Status.ACTIVE){

            this.currPlayer = this.isWhiteTurn ? player1 : player2;

            System.out.println(currPlayer.getPlayerName() + "'s turn (" + (currPlayer.isWhitePlayer() ? "White" : "Black") + ")");

            System.out.println("Enter Start row & col e.g(6 4)");
            int startRow = scanner.nextInt();
            int startCol = scanner.nextInt();

            System.out.println("Enter End row & col e.g(6 4)");
            int endRow = scanner.nextInt();
            int endCol = scanner.nextInt();

            Cell startCell = this.board.getCell(startRow,startCol);
            Cell endCell = this.board.getCell(endRow,endCol);

            if(startCell == null || startCell.getPiece() == null){
                System.out.println("Invalid Move.");
                continue;
            }

            makeMove(new Move(startCell,endCell),currPlayer);
        }
    }

    public void makeMove(Move move,Player player){

        while(move.isValid()){

            Piece sourcePiece = move.getStartCell().getPiece();

            if(sourcePiece.canMove(this.board,move.getStartCell(),move.getEndCell())){

                Piece destPiece = move.getEndCell().getPiece();

                if(destPiece != null){

                    if(destPiece instanceof King && this.isWhiteTurn){
                        this.status = Status.WHITE_WIN;
                        return;
                    }
                    if(destPiece instanceof King && !this.isWhiteTurn){
                        this.status = Status.BLACK_WIN;
                        return;
                    }
                    destPiece.setKilled();
                }

                move.getEndCell().setPiece(sourcePiece);
                move.getStartCell().setPiece(null);

                this.isWhiteTurn = !this.isWhiteTurn;
            }
        }
    }
};
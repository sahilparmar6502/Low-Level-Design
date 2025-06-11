package Controller;

import Utility.Board;
import Utility.Player;
import Utility.Position;

public class TicTacToe{

    private int n;
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currPlayer;
    private Player winner;

    public TicTacToe(int n,Player playerX,Player playerO){
        this.n = n;
        this.board = new Board(n);
        this.playerX = playerX;
        this.playerO = playerO;
        this.currPlayer = playerX;
        this.winner = null;
    }

    public void play(){

        // play -> draw -> one of the player wins
        while(this.board.isDrawState()){
            this.board.printGrid();

            Position pos = this.currPlayer.getPlayerStrategy().makeMove(this.board);
            this.board.makeMove(pos,this.currPlayer.getSymbol());

            if(this.board.isWinningLine(pos,this.currPlayer.getSymbol())){
                this.winner = this.currPlayer;
                break;
            }

            swichPlayer();
        }

        announceResult();
    }

    public void swichPlayer(){
        this.currPlayer = this.currPlayer == this.playerX ? playerO : playerX;
    }

    public void announceResult(){

        if(this.winner == playerX){
            System.out.println("Result:PlayerX is winner!");
        }
        else if(this.winner == playerO){
            System.out.println("Result:PlayerO is winner!");
        }
        else{
            System.out.println("Result:Match is draw!");
        }
    }
};
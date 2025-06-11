package PieceFactoryPackage;

import MovementStrategyPackage.MovementStrategy;
import Utility.Board;
import Utility.Cell;

public abstract class Piece{

    private boolean isWhitePiece;
    private boolean killed = false;
    private MovementStrategy movementStrategy;

    public Piece(boolean isWhitePiece,MovementStrategy movementStrategy){
        this.isWhitePiece = isWhitePiece;
        this.movementStrategy = movementStrategy;
    }

    public boolean isWhite(){
        return this.isWhitePiece;
    }

    public boolean isKilled(){
        return this.killed;
    }

    public void setKilled(){
        this.killed = true;
    }

    public MovementStrategy getMovementStrategy(){
        return this.movementStrategy;
    }

    public boolean canMove(Board board,Cell startCell,Cell endCell){
        return this.movementStrategy.canMove(board,startCell,endCell);
    }
};
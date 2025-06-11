package PieceFactoryPackage.ConcretePieces;

import MovementStrategyPackage.ConcreteMovementStrategy.QueenMovementStrategy;
import Utility.Board;
import Utility.Cell;
import PieceFactoryPackage.Piece;

public class Queen extends Piece{

    public Queen(boolean isWhitePiece){
        super(isWhitePiece, new QueenMovementStrategy());
    }

    public boolean canMove(Board board,Cell startCell,Cell endCell){
        return super.canMove(board,startCell,endCell);
    }
};
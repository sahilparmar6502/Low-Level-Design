package PieceFactoryPackage.ConcretePieces;

import MovementStrategyPackage.ConcreteMovementStrategy.BishopMovementStrategy;
import Utility.Board;
import Utility.Cell;
import PieceFactoryPackage.Piece;

public class Bishop extends Piece{

    public Bishop(boolean isWhitePiece){
        super(isWhitePiece, new BishopMovementStrategy());
    }

    public boolean canMove(Board board,Cell startCell,Cell endCell){
        return super.canMove(board,startCell,endCell);
    }
};
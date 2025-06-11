package PieceFactoryPackage.ConcretePieces;

import MovementStrategyPackage.ConcreteMovementStrategy.KnightMovementStrategy;
import Utility.Board;
import Utility.Cell;
import PieceFactoryPackage.Piece;

public class Knight extends Piece{

    public Knight(boolean isWhitePiece){
        super(isWhitePiece, new KnightMovementStrategy());
    }

    public boolean canMove(Board board,Cell startCell,Cell endCell){
        return super.canMove(board,startCell,endCell);
    }
};
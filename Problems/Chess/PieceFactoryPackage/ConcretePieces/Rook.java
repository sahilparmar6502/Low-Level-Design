package PieceFactoryPackage.ConcretePieces;

import MovementStrategyPackage.ConcreteMovementStrategy.RookMovementStrategy;
import Utility.Board;
import Utility.Cell;
import PieceFactoryPackage.Piece;

public class Rook extends Piece{

    public Rook(boolean isWhitePiece){
        super(isWhitePiece, new RookMovementStrategy());
    }

    public boolean canMove(Board board,Cell startCell,Cell endCell){
        return super.canMove(board,startCell,endCell);
    }
};
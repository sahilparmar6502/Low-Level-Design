package PieceFactoryPackage.ConcretePieces;

import MovementStrategyPackage.ConcreteMovementStrategy.PawnMovementStrategy;
import Utility.Board;
import Utility.Cell;
import PieceFactoryPackage.Piece;

public class Pawn extends Piece{

    public Pawn(boolean isWhitePiece){
        super(isWhitePiece, new PawnMovementStrategy());
    }

    public boolean canMove(Board board,Cell startCell,Cell endCell){
        return super.canMove(board,startCell,endCell);
    }
};
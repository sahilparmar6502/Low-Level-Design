package MovementStrategyPackage.ConcreteMovementStrategy;

import MovementStrategyPackage.MovementStrategy;
import Utility.Board;
import Utility.Cell;

public class PawnMovementStrategy implements MovementStrategy{

    @Override
    public boolean canMove(Board board,Cell startCell,Cell endCell){
        return true;
    }
};
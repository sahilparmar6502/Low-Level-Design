package MovementStrategyPackage;

import Utility.Board;
import Utility.Cell;

public interface MovementStrategy{
    boolean canMove(Board board,Cell startCell,Cell endCell);
};
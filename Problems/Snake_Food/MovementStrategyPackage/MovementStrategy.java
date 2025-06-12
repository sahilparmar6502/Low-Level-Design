package MovementStrategyPackage;

import Utility.Pair;

public interface MovementStrategy{
    Pair nextMove(Pair currHead,String direction);
};
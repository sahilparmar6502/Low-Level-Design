package Utility;

import PlayerStrategy.PlayerStrategy;
import CommonEnum.Symbol;

public class Player{

    private Symbol symbol;
    private PlayerStrategy playerStrategy;

    public Player(Symbol symbol,PlayerStrategy playerStrategy){
        this.symbol = symbol;
        this.playerStrategy = playerStrategy;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }

    public PlayerStrategy getPlayerStrategy(){
        return this.playerStrategy;
    }
};
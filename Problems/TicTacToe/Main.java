import PlayerStrategy.ConcreteStrategy.HumanPlayerStrategy;
import Controller.TicTacToe;
import Utility.Player;
import CommonEnum.Symbol;

public class Main{

    public static void main(String args[]){

        Player playerX = new Player(Symbol.X,new HumanPlayerStrategy("PlayerX"));
        Player playerO = new Player(Symbol.O,new HumanPlayerStrategy("PlayerO"));
        
        TicTacToe game = new TicTacToe(3,playerX,playerO);
        game.play();
    }
};
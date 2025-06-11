import Controller.Chess;
import Utility.Player;

public class Main{
    public static void main(String args[]){

        Player player1 = new Player("PlayerW",true);
        Player player2 = new Player("PlayerB",false);

        Chess chess = new Chess(8,player1,player2);
        chess.start();
    }
};
package PlayerStrategy.ConcreteStrategy;

import java.util.Scanner;
import Utility.Position;
import Utility.Board;
import PlayerStrategy.PlayerStrategy;

public class HumanPlayerStrategy implements PlayerStrategy{

    private String playerName;
    private Scanner scanner;

    public HumanPlayerStrategy(String playerName){
        this.playerName = playerName;
        this.scanner = new Scanner(System.in);
    }

    public Position makeMove(Board board){

        while(true){

            System.out.printf("%s, enter your move:",playerName);
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            Position pos = new Position(r,c);

            if(board.isValidMove(pos)){
                return pos;
            }

            System.out.println("Invalid move.");
        }
    }
}

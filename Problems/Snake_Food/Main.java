import Controller.SnakeFoodGame;
import java.util.Scanner;

public class Main{

    public static void main(String args[]){

        int height = 10;
        int width = 10;
        int[][] foods = {{0,1},{5,5},{1,2},{9,9},{9,2}};

        SnakeFoodGame game = new SnakeFoodGame(height,width,foods);

        System.out.println("Controls:");
        System.out.println("W (UP):");
        System.out.println("S (Down):");
        System.out.println("D (Right):");
        System.out.println("A (Left):");
        System.out.println("---------------- Game starts now. ---------------");

        Scanner scanner = new Scanner(System.in);
        int score = 0;
        boolean gameRunning = true;

        while(gameRunning){

            // displayGameState();

            System.out.println("Enter move (W/S/D/S) or Q to quit.");
            String input = scanner.nextLine().toUpperCase();

            if(input.equals("Q")){
                gameRunning = false;
                System.out.println("Game is ended by player. Score:"+score);
                continue;
            }

            String direction = convertInput(input);

            if(direction == ""){
                System.out.println("Invalid move. Enter (W/S/D/A) or Q to quit.");
                continue;
            }

            score = game.move(direction);

            if(score == -1){
                System.out.println("Game Over!");
                System.out.println("Final Score:"+score);
                gameRunning = false;
            }
            else{
                System.out.println("Score:"+score);
            }
        }
        scanner.close();
        System.out.println("Thanks for Playing!!");
    }

    private static String convertInput(String input){

        switch(input){
            case "W":
                return "U";
            case "S":
                return "D";
            case "A":
                return "L";
            case "D":
                return "R";
            default:
                return "";
        }
    }
};
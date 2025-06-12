package Controller;

import Utility.Pair;
import Utility.Board;
import Utility.Snake;
import MovementStrategyPackage.ConcreteStrategies.HumanMovementStrategy;
import MovementStrategyPackage.MovementStrategy;

public class SnakeFoodGame{

    private Board board;
    private Snake snake;
    private MovementStrategy movementStrategy;
    private int[][] foods;
    private int foodIndex;

    public SnakeFoodGame(int height,int width,int[][] foods){

        this.foods = foods;
        this.foodIndex = 0;
        this.board = Board.getInstance(height,width);
        this.snake = Snake.getInstance();

        // default strategy
        this.movementStrategy = new HumanMovementStrategy();
    }

    public void setStrategy(MovementStrategy movementStrategy){
        this.movementStrategy = movementStrategy;
    }

    public int move(String direction){

        Pair currHead = this.snake.peekFirst();

        Pair newHead = this.movementStrategy.nextMove(currHead,direction);

        boolean isCollided = this.board.checkBoundary(newHead) || this.snake.bitesItself(newHead);

        if(isCollided){
            return -1;
        }

        //check ateFood
        boolean ateFood = (this.foodIndex < this.foods.length) && (this.foods[this.foodIndex][0] == newHead.getRow()) && (this.foods[this.foodIndex][1] == newHead.getCol());

        if(ateFood){
            System.out.println("Food Found");
            this.foodIndex += 1;
        }
        else{
            // no food eaten, remove tail
            this.snake.pollLast();
            // also remove last/tail from positionMap
            this.snake.remove(this.snake.peekLast());
        }

        this.snake.addFirst(newHead);
        this.snake.put(newHead);
        int score = this.snake.getSize() - 1;
        return score;
    }
};
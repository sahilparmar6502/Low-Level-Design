package Utility;

// Singleton Pattern
public class Board{

    private static Board instance; // static data-member
    private int height;
    private int width;

    private Board(int height,int width){
        this.height = height;
        this.width = width;
    }

    public static Board getInstance(int height,int width){ // static method
        if(instance == null){
            instance = new Board(height,width);
        }
        return instance;
    }

    public int getHeight(){ return this.height; }
    public int getWidth(){ return this.width; }

    public boolean checkBoundary(Pair snakeHead){
        int row = snakeHead.getRow();
        int col = snakeHead.getCol();

        if(row < 0 || col < 0 || row >= this.height || col >= this.width){
            return true;
        }
        return false;
    }
};

// static data-member or method doesn't belongs to instance of the class
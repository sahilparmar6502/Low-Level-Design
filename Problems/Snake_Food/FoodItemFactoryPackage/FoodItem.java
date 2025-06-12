package FoodItemFactoryPackage;

public abstract class FoodItem{

    protected int row;
    protected int col;
    protected int point;

    public FoodItem(int row,int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow(){ return this.row; }
    public int getCol(){ return this.col; }
    public int getPoint(){ return this.point; }
};
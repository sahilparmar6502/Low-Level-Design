package FoodItemFactoryPackage.ConcreteFoodItem;

import FoodItemFactoryPackage.FoodItem;

public class NormalFood extends FoodItem{

    public NormalFood(int row,int col,int point){
        super(row,col);
        this.point = point;
    }
};
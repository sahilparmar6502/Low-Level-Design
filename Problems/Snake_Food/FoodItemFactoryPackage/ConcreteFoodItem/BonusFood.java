package FoodItemFactoryPackage.ConcreteFoodItem;

import FoodItemFactoryPackage.FoodItem;

public class BonusFood extends FoodItem{

    public BonusFood(int row,int col,int point){
        super(row,col);
        this.point = point;
    }
};
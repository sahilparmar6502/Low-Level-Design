package FoodItemFactoryPackage;

import FoodItemFactoryPackage.ConcreteFoodItem.*;

public class FoodItemFactory{

    public static FoodItem createFood(int row,int col,String foodType){

        if("bonus".equals(foodType)){
            return new BonusFood(row,col,3);
        }
        return new NormalFood(row,col,1);
    }
};
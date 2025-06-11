
public class Main{

    public static void main(String args[]){

        BasePizza pizza = new Margherita();
        pizza = new ExtraCheeze(pizza);
        pizza = new Mashroom(pizza);

        BasePizza pizza2 = new VegDelight();
        pizza2 = new Mashroom(pizza2);

        int totalCost = pizza.getCost();
        System.out.println("Total Cost:"+totalCost+"\n");

        int totalCost2 = pizza2.getCost();
        System.out.println("Total Cost:"+totalCost2);
    }
};
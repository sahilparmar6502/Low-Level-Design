
class ExtraCheeze extends PizzaTopping{

    private BasePizza basePizza;
    private int cost = 40;

    ExtraCheeze(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    public int getCost(){
        System.out.println("Extra Cheeze:"+cost);
        return basePizza.getCost() + this.cost;
    }
}
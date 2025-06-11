
class Mashroom extends BasePizza{

    private int cost = 50;
    private BasePizza basePizza;

    Mashroom(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    public int getCost(){
        System.out.println("Mashroom:"+this.cost);
        return this.basePizza.getCost() + this.cost;
    }
};
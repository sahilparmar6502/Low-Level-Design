
class NumberExpression implements Expression{

    private int num;

    NumberExpression(int num){
        this.num = num;
    }

    public int interprete(){
        return this.num;
    }
};
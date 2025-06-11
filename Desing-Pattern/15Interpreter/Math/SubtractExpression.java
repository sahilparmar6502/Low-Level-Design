
class SubtractExpression implements Expression{

     private Expression left;
    private Expression right;

    SubtractExpression(Expression left,Expression right){
        this.left = left;
        this.right = right;
    }

    public int interprete(){
        return left.interprete() - right.interprete();
    }
};
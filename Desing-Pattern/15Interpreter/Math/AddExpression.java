
class AddExpression implements Expression{

    private Expression left;
    private Expression right;

    AddExpression(Expression left,Expression right){
        this.left = left;
        this.right = right;
    }

    public int interprete(){
        return left.interprete() + right.interprete();
    }
};
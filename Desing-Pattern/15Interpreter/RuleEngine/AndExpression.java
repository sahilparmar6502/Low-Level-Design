
class AndExpression implements Expression{

    private Expression exp1;
    private Expression exp2;

    AndExpression(Expression exp1,Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public boolean interprete(Context context){
        return exp1.interprete(context) && exp2.interprete(context);
    }
};
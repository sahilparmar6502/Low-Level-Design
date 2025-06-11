
public class Main{
    public static void main(String args[]){

        // (5 + 3) - 2
        Expression num1 = new NumberExpression(5);
        Expression num2 = new NumberExpression(3);
        Expression num3 = new NumberExpression(2);

        Expression addExpression =  new AddExpression(num1,num2);
        Expression subtractExpression = new SubtractExpression(addExpression,num3);

        int res = subtractExpression.interprete();

        System.out.println("Res:"+res);
    }
};
package PaymentStrategyPackage;

import PaymentStrategyPackage.ConcretePaymentStrategy.*;

public class Payment{

    private double amount;
    private PaymentStrategy paymentStrategy ;

    public Payment(double amount,PaymentStrategy paymentStrategy){
        this.amount = amount;
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount){
        if(amount <= 0){
            System.out.println("Invalid amount.");
        }
        else{
            this.paymentStrategy.processPayment(amount);
        }
    }
};
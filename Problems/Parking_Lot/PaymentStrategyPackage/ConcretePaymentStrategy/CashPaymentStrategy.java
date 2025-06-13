package PaymentStrategyPackage.ConcretePaymentStrategy;

import PaymentStrategyPackage.PaymentStrategy;

public class CashPaymentStrategy implements PaymentStrategy{
    public void processPayment(double amount){
        System.out.println("Processing payment by cash of $"+amount);
    }
};
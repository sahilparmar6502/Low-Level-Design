package PaymentStrategyPackage.ConcretePaymentStrategy;

import PaymentStrategyPackage.PaymentStrategy;

public class CashPaymentStrategy {
    public void processPayment(double amount){
        System.out.println("Processing payment by cash of $"+amount);
    }
};
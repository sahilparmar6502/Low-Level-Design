
class CreditCardPayment implements Payment{

    public void pay(int amount){
        System.out.println(amount + " Rs. paid using Credit Card.");
    }
};
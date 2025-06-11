
class Cart{

    private Payment payment;

    public void setPaymentMethod(Payment payment){
        this.payment = payment;
    }

    public void checkout(int amount){
        this.payment.pay(amount);
    }
};
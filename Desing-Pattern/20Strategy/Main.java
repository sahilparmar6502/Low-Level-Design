
public class Main{
    public static void main(String args[]){

        Cart cart = new Cart();

        cart.setPaymentMethod(new CashPayment());
        cart.checkout(5000);

        cart.setPaymentMethod(new UPIPayment());
        cart.checkout(5690);
    }
};
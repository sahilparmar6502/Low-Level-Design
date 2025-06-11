
public class Main{

    public static void main(String args[]){

        IphoneStockSubject iphoneStockSubject = new IphoneStockSubject(0);

        Observer observer1 = new EmailObserver("abc@gmail.com",iphoneStockSubject);
        Observer observer2 = new EmailObserver("123@gmail.com",iphoneStockSubject);
        Observer observer3 = new SMSObserver("9087967543",iphoneStockSubject);

        iphoneStockSubject.addObserver(observer1);
        iphoneStockSubject.addObserver(observer2);
        iphoneStockSubject.addObserver(observer3);

        iphoneStockSubject.setData(10);
    }
};
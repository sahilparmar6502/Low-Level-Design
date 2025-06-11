

class SMSObserver implements Observer{

    private String number;
    private Subject subject;

    SMSObserver(String number,Subject subject){
        this.subject = subject;
        this.number = number;
    }

    public void update(String msg){
        System.out.println(this.number + " is notified:"+msg);
    }
};
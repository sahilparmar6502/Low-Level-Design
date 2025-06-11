
class EmailObserver implements Observer{

    private String mailAddress;
    private Subject subject;

    EmailObserver(String mailAddress,Subject subject){
        this.subject = subject;
        this.mailAddress = mailAddress;
    }

    public void update(String msg){
        System.out.println(this.mailAddress + " is notified:"+msg);
    }
};
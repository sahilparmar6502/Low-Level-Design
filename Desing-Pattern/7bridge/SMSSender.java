
public class SMSSender implements MessageSender{
    public void send(String message){
        System.out.println("[SMS] sending '"+message+"'");
    }
}
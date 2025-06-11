
public class Main{
    public static void main(String args[]){

        MessageSender sender1 = new SMSSender();
        MessageSender sender2 = new EmailSender();

        Message message = new EmergencyMessage(sender1);
        message.send("108 live");

        Message message2 = new GeneralMessage(sender2);
        message2.send("Society meeting at 9:30 PM");
    }
}
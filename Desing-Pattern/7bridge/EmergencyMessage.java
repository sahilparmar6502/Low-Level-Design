
public class EmergencyMessage extends Message{

    public EmergencyMessage(MessageSender sender){
        super(sender);
    }

    public void send(String content){
        System.out.println("Emergency...");
        sender.send(content);
    }
}
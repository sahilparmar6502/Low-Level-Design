
public class GeneralMessage extends Message{

    GeneralMessage(MessageSender sender){
        super(sender);
    }

    public void send(String content){
        System.out.println("General info.");
        sender.send(content);
    }
}
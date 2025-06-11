
class User{

    private String name;
    private ChatMediator chat;

    User(String name,ChatMediator chat){
        this.name = name;
        this.chat = chat;
    }

    public String getName(){
        return this.name;
    }

    public void send(String message){
        System.out.println(this.name + " sends " + message);
        this.chat.showMessage(message,this);
    }

    public void receive(String message,String sender){
        System.out.println(this.name + " receives message:"+message+" from "+sender);
    }
};
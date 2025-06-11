import java.util.List;
import java.util.ArrayList;

class ChatRoom implements ChatMediator{

    private List<User> users;

    ChatRoom(){
        users = new ArrayList<User>();
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void showMessage(String message,User sender){

        for(User user : users){
            if(user != sender){
                user.receive(message,sender.getName());
            }
        }
        System.out.println();
    }
};
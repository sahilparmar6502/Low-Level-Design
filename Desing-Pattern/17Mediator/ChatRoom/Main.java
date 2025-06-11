
public class Main{

    public static void main(String args[]){

        // ChatMediator chat = new ChatRoom();
        // Interface reference -> cannot call the methods of Object

        ChatRoom chat = new ChatRoom();

        User user1 = new User("Alice",chat);
        User user2 = new User("Bob",chat);
        User user3 = new User("John",chat);

        chat.addUser(user1);
        chat.addUser(user2);
        chat.addUser(user3);

        user1.send("Good Morning!");
        user2.send("Good Afternoon!");
    }
};
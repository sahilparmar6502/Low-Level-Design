
public class Main{
    public static void main(String args[]){

        ProxyServer server = new ProxyServer();

        server.handleRequest("Alice");
        server.handleRequest("MaliciousClient");
    }
}
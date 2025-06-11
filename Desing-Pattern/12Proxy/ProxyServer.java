import java.util.*;

class ProxyServer implements Server{

    private RealServer realServer = new RealServer();
    private static List<String> blockedClients;

    static{
        blockedClients = new ArrayList<>();
        blockedClients.add("MaliciousClient");
        blockedClients.add("Spammer");
    }

    public void handleRequest(String client){
        if(blockedClients.contains(client)){
            System.out.println("ProxyServer: access denied for "+client);
        }
        else{
            System.out.println("ProxyServer: access granted for "+client);
            realServer.handleRequest(client);
        }
    }
};
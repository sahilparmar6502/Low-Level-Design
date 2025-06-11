
class RealServer implements Server{
    public void handleRequest(String client){
        System.out.println("RealServer: handling request from "+client);
    }
};
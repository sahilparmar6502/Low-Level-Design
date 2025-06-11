
class RemoteController{

    private Command command;

    RemoteController(Command command){
        this.command = command;
    }

    public void press(){
        command.execute();
    }
};
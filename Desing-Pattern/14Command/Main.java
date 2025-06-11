
public class Main{
    public static void main(String args[]){

        Light light = new Light();
        Fan fan = new Fan();

        LightCommand lightCommand = new LightCommand(light);
        FanCommand FanCommand = new FanCommand(fan);

        RemoteController lightRemote = new RemoteController(lightCommand);
        RemoteController fanRemote = new RemoteController(FanCommand);

        // lightRemote.press();

        // fanRemote.press();

        MacroCommand allCommmand = new MacroCommand();
        allCommmand.add(lightCommand);
        allCommmand.add(FanCommand);

        RemoteController generalRemote = new RemoteController(allCommmand);
        generalRemote.press();

    }
};
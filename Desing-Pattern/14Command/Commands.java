
class LightCommand implements Command{

    private Light light;

    LightCommand(Light light){
        this.light = light;
    }

    public void execute(){
        light.turnOn();
    }
};

class FanCommand implements Command{

    private Fan fan;

    FanCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute(){
        fan.start();
    }
};

class YellowLight implements TrafficLightState{

    public void changeState(TrafficLightContext context){
        System.out.println("Yellowlight is switching to Red.");
        context.setState(new RedLight());
    }
};
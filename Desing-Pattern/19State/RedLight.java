
class RedLight implements TrafficLightState{

    public void changeState(TrafficLightContext context){
        System.out.println("Redlight is switching Green.");
        context.setState(new GreenLight());
    }
};
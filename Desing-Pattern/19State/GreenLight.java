
class GreenLight implements TrafficLightState{

    public void changeState(TrafficLightContext context){
        System.out.println("Greenlight is switching to Yellow.");
        context.setState(new YellowLight());
    }
};
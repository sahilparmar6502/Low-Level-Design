
class TrafficLightContext{

    private TrafficLightState currState;

    TrafficLightContext(){
        this.currState = new RedLight();
    }

    public void setState(TrafficLightState newState){
        this.currState = newState;
    }

    public void change(){
        this.currState.changeState(this);
    }
};

class TVFacade{

    private TVScreen tvScreen;
    private Speaker speaker;
    private Netflix netflix;

    TVFacade(){
        tvScreen = new TVScreen();
        speaker = new Speaker();
        netflix = new Netflix();
    }

    public void turnOn(){
        tvScreen.turnOn();
        speaker.turnOn();
        netflix.startStreaming();
    }
};
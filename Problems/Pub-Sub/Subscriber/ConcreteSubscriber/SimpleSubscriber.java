package Subscriber.ConcreteSubscriber;

import Subscriber.ISubscriber;
import Model.Message;

public class SimpleSubscriber implements ISubscriber{

    private final String id;

    public SimpleSubscriber(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public void onMessage(Message message) throws InterruptedException{
        System.out.println("Subscriber:" + id + "received Message:" + message.getMessage());
        Thread.sleep(500);
    }
};
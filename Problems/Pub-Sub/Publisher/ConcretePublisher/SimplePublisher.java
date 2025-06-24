package Publisher.ConcretePublisher;

import Controller.KafkaController;
import Publisher.IPublisher;
import Model.Message;

public class SimplePublisher implements IPublisher{

    private String id;
    private KafkaController controller;

    public SimplePublisher(String id,KafkaController controller){
        this.id = id;
        this.controller = controller;
    }

    public String getId(){
        return this.id;
    }

    public void publish(String topicId,Message message) throws IllegalArgumentException{
        controller.publish(this,topicId,message);
        System.out.println("Publisher: " + this.id + " published message:" + message.getMessage() + " Topic:" + topicId);
    };
};
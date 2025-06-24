import Controller.KafkaController;
import Model.Message;
import Model.Topic;
import Subscriber.ConcreteSubscriber.SimpleSubscriber;
import Publisher.ConcretePublisher.SimplePublisher;

public class Main{

    public static void main(String args[]){

        KafkaController kafkaController = new KafkaController();

        Topic topic1 = kafkaController.createTopic("Topic1");
        Topic topic2 = kafkaController.createTopic("Topic2");

        SimpleSubscriber subscriber1 = new SimpleSubscriber("Subscriber1");
        SimpleSubscriber subscriber2 = new SimpleSubscriber("Subscriber2");
        SimpleSubscriber subscriber3 = new SimpleSubscriber("Subscriber3");
        SimpleSubscriber subscriber4 = new SimpleSubscriber("Subscriber4");

        kafkaController.subscribe(subscriber1,topic1.getTopicId());
        kafkaController.subscribe(subscriber2,topic2.getTopicId());
        kafkaController.subscribe(subscriber3,topic1.getTopicId());
        kafkaController.subscribe(subscriber4,topic2.getTopicId());

        SimplePublisher publisher1 = new SimplePublisher("Publisher1",kafkaController);
        SimplePublisher publisher2 = new SimplePublisher("Publisher2",kafkaController);

        publisher1.publish(topic1.getTopicId(),new Message("Good Morning"));
        publisher1.publish(topic1.getTopicId(),new Message("Good Afternoon"));
        publisher2.publish(topic2.getTopicId(),new Message("Good Evening"));

        try{
            Thread.sleep(5000);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        kafkaController.shutdown();
    }   
}
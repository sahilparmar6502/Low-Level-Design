package Controller;

import Model.Message;
import Model.Topic;
import Publisher.IPublisher;

public class TopicPublisherController{

    private final Topic topic;
    private final IPublisher publisher;

    public TopicPublisherController(final Topic topic,final IPublisher publisher){
        this.topic = topic;
        this.publisher = publisher;
    }

    public void publish(Message message, KafkaController controller){
        controller.publish(publisher,topic,message);
        System.out.println("Publisher: " + publisher.getId() + " published Message:" + message.getMessage() + " Topic:" + topic.getTopicName());
    }
};
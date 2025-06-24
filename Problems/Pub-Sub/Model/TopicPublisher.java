package Model;

import Publisher.IPublisher;

public class TopicPublisher{

    private Topic topic;
    private IPublisher publisher;

    public TopicPublisher(Topic topic,IPublisher publisher){
        this.topic = topic;
        this.publisher = publisher;
    }

    public Topic getTopic(){
        return this.topic;
    }

    public IPublisher getPublisher(){
        return this.publisher;
    }
};
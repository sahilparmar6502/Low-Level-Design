package Model;

import Subscriber.ISubscriber;
import java.util.concurrent.atomic.AtomicInteger;

public class TopicSubscriber{

    private Topic topic;
    private ISubscriber subscriber;
    private AtomicInteger offset;

    public TopicSubscriber(Topic topic, ISubscriber subscriber){
        this.topic = topic;
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }

    public Topic getTopic(){
        return this.topic;
    }

    public ISubscriber getSubscriber(){
        return this.subscriber;
    }

    public AtomicInteger getOffset(){
        return this.offset;
    }
};
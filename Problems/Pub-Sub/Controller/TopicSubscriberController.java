package Controller;

import Model.Message;
import Model.Topic;
import Subscriber.ISubscriber;
import Model.TopicSubscriber;

public class TopicSubscriberController implements Runnable{

    private final TopicSubscriber topicSubscriber;

    public TopicSubscriberController(final TopicSubscriber topicSubscriber){
        this.topicSubscriber = topicSubscriber;
    }

    @Override
    public void run(){
        Topic topic = topicSubscriber.getTopic();
        ISubscriber subscriber = topicSubscriber.getSubscriber();

        while(true){

            Message message = null;

            synchronized(topicSubscriber){

                while(topicSubscriber.getOffset().get() >= topic.getMessages().size()){
                    try{
                        topicSubscriber.wait();
                    }
                    catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                int currentOffset = topicSubscriber.getOffset().getAndIncrement();
                message = topic.getMessages().get(currentOffset);
            }

            try{
                subscriber.onMessage(message);
            }
            catch(InterruptedException e){
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
};

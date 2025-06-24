package Controller;

import Model.Message;
import Model.Topic;
import Model.TopicSubscriber;
import Publisher.IPublisher;
import Subscriber.ISubscriber;

import java.util.Map;
import java.util.List;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class KafkaController{

    // ID -> Topic
    private final Map<String,Topic> topics;

    // TopicID -> TopicSubscribers
    private final Map<String, List<TopicSubscriber>> topicSubscribers;

    // Executor Service
    private final ExecutorService executor;
    private final AtomicInteger topicCounter;

    public KafkaController(){
        this.topics = new ConcurrentHashMap<>();
        this.topicSubscribers = new ConcurrentHashMap<>();
        this.executor = Executors.newCachedThreadPool();
        this.topicCounter = new AtomicInteger(0);
    }

    public Topic createTopic(String topicName){
        String topicId = String.valueOf(this.topicCounter.getAndIncrement());
        // valueOf() -> converts non-string object to string object
        Topic topic = new Topic(topicId,topicName);
        topics.put(topicId, topic);

        topicSubscribers.put(topicId, new CopyOnWriteArrayList<>());
        System.out.println("Create Topic:" + topicName + " with ID:" + topicId);
        return topic;
    }

    public void subscribe(ISubscriber subscriber, String topicId){

        Topic topic = this.topics.get(topicId);

        if(topic == null){
            System.out.println("Topic with ID:" + topicId + " does not exist.");
            return;
        }

        TopicSubscriber topicSubscriber = new TopicSubscriber(topic,subscriber);
        this.topicSubscribers.get(topicId).add(topicSubscriber);

        this.executor.submit(new TopicSubscriberController(topicSubscriber));
        System.out.println("Subscriber " + subscriber.getId() + " subscribed to Topic:" + topic.getTopicName());

    }

    public void publish(IPublisher publisher, String topicId, Message msg){

        Topic topic = this.topics.get(topicId);

        if(topic == null){
            System.out.println("Topic with ID:" + topicId + " does not exist.");
            return;
        }

        topic.addMessage(msg);

        //publish to all the subscribers of topic
        for(TopicSubscriber topicSubscriber : this.topicSubscribers.get(topicId)){
            synchronized(topicSubscriber){
                topicSubscriber.notify();
            }
        }

        System.out.println("Message " + msg.getMessage() + " published to Topic:" + topic.getTopicName());
    }

    public void resetOffset(String topicId,ISubscriber subscriber,int newOffset){

        List<TopicSubscriber> subscribers = this.topicSubscribers.get(topicId);

        if(subscribers == null){
            System.out.println("Topic with ID:" + topicId + " does not exist");
            return;
        }

        for(TopicSubscriber ts : subscribers){
            if(ts.getSubscriber().getId().equals(subscriber.getId())){
                ts.getOffset().set(newOffset);

                synchronized(ts){
                    ts.notify();
                }

                System.out.println("Offset for subscriber " + subscriber.getId() + " Topic:" + topicId + " reset to" + newOffset);
                break;
            }
        }
    }

    public void shutdown(){
        executor.shutdown();

        try{
            if(!executor.awaitTermination(5, TimeUnit.SECONDS)){
                executor.shutdownNow();
            }
        }
        catch(InterruptedException e){
            executor.shutdownNow();
        }
    }
};
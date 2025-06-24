package Model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Topic{

    private final String topicName;
    private final String topicId;
    private List<Message> messages;

    public Topic(final String topicId,final String topicName){
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<Message>();
    }

    public String getTopicName(){
        return this.topicName;
    }

    public String getTopicId(){
        return this.topicId;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public synchronized List<Message> getMessages(){
        return Collections.unmodifiableList(messages);
    }
};
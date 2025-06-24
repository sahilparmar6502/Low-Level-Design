package Publisher;

import Model.Message;

public interface IPublisher{

    String getId();
    void publish(String topicId,Message message) throws IllegalArgumentException;
};
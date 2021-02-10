package kafkaservice1.kafka.consumer;

import kafkaservice1.kafka.service.UpdateMessageArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerUtil {

    @Autowired
    UpdateMessageArray updateMessageArray;

    // TODO you have to change the group id to get message in consumer if running
    @KafkaListener(topics = "${kafka.topicName}", groupId = "124")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
        updateMessageArray.updateArray(message);
    }
}

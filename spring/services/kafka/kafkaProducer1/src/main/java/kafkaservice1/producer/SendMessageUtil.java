package kafkaservice1.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class SendMessageUtil {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.topicName}")
    private String topicName="topicName";

    public void sendMessage(String message){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("Unable to send the message "+message+" due to "+throwable.getLocalizedMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                System.out.println("Sent Message : "+message+" with offset "+stringStringSendResult.getRecordMetadata().offset()+" \t]");
            }
        });
    }

}

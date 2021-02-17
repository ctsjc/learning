package kafkaservice1.rest;

import kafkaservice1.producer.SendMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class JController {

    @Autowired
    SendMessageUtil sendMessageUtil;
    @PostMapping("/sendMessage")
    public String postMessage(@RequestParam(defaultValue = "Jay Shree Ram ") String someValue){
        System.out.println("\n\nNew Request Recieved\n\n\n");
        sendMessageUtil.sendMessage(someValue);
        String timeStamp = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());

        return "Message Dropped @"+timeStamp;
    }
}

package kafkaservice1.rest;

import kafkaservice1.producer.SendMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JController {

    @Autowired
    SendMessageUtil sendMessageUtil;
    @PostMapping("/sendMessage")
    public void postMessage(@RequestParam(defaultValue = "Jay Shree Ram ") String someValue){
        sendMessageUtil.sendMessage(someValue);
    }
}

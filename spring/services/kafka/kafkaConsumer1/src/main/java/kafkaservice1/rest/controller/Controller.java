package kafkaservice1.rest.controller;

import kafkaservice1.kafka.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    MessageService messageService;
    @GetMapping
    public List<String> getMessages(){
        System.out.println("\n\n\n\n New Get Request is received ......\n\n\n\n");
        List<String> list=null;
        return messageService.getList();
    }
}

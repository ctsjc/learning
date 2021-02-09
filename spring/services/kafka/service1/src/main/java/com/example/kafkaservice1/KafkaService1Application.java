package com.example.kafkaservice1;

import com.example.kafkaservice1.producer.SendMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaService1Application {

    @Autowired
    SendMessageUtil sendMessageUtil;
    public static void main(String[] args) {
        SpringApplication.run(KafkaService1Application.class, args);
    }

}

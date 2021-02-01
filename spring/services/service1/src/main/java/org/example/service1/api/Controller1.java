package org.example.service1.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {
    @GetMapping("{name}")
    String sendHello(@PathVariable  String name){
        return "Hello "+name;
    }
}

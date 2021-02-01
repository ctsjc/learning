package org.example.service2.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.UnknownHostException;
import java.util.Optional;

@RestController
public class Controller1 {
    RestTemplate restTemplate=new RestTemplate();

    @Value("${service1.host}")
    String host;
    @Value("${service1.port}")
    String port;

    @GetMapping()
    ResponseEntity<String> sendHello(){
        ResponseEntity<String> responseEntity=ResponseEntity.of(Optional.of("Error"));
        UriComponents uriComponents = UriComponentsBuilder.newInstance().
                scheme("http").host(host).port(port).path("service2").build();
        System.out.println(uriComponents.toUriString());
        try {
            responseEntity = restTemplate.getForEntity(uriComponents.toUriString(), String.class);
        }catch (Exception e){
            System.out.println("Exception");
        }
        return responseEntity;
    }
}

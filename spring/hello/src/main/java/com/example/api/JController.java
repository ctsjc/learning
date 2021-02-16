package com.example.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class JController {
    @GetMapping()
    public List<String> health(){
        return Arrays.asList("Jitendra");
    }
}

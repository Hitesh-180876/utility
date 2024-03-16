package com.example.utility.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    @Autowired
    private WebClient.Builder webClientBuilder;


    @GetMapping("/hi")
    public Mono<String> sayHi(){
        String url = "http://localhost:8080/hi-demo";
        Mono<String> response =
                webClientBuilder.build().get().uri(url).retrieve().bodyToMono(String.class);
        return response;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hi Hitesh";
    }

}

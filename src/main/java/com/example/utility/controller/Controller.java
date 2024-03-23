package com.example.utility.controller;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    @Autowired
    private WebClient.Builder webClientBuilder;

    Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/hi")
    @Observed(
            name = "user.name",
            contextualName = "demo-service",
            lowCardinalityKeyValues = {"userType", "userType2"}
    )
    public Mono<String> sayHi(){
        String url = "http://localhost:8080/hi-demo";
        logger.info(url);
        Mono<String> response =
                webClientBuilder.build().get().uri(url).retrieve().bodyToMono(String.class);
        Mono<String> response1 =
                webClientBuilder.build().get().uri(url).retrieve().bodyToMono(String.class);
        return response;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "Hi Hitesh";
    }

}

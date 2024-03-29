package com.example.utility.config;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class Observer {

    @Bean
    ObservedAspect observedAspect(ObservationRegistry observationRegistry){
        return new ObservedAspect(observationRegistry);
    }
}

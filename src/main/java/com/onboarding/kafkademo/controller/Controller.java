package com.onboarding.kafkademo.controller;

import com.onboarding.kafkademo.service.HelloToStatic;
import com.onboarding.kafkademo.service.HelloToViaKafkaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
public class Controller {
    private final HelloToStatic helloToStatic;
    private final HelloToViaKafkaService helloToViaKafkaService;

    @GetMapping("/")
    public String sayHello() {
        log.info("#hello world");
        return "Hello, World!";
    }

    @GetMapping("/say-hello")
    public String sayHelloWithName(String name) {
        log.info("#/say-hello");
        return helloToStatic.sayHello(name);
    }

    @GetMapping("/say-hello-via-kafka")
    public String sayHelloViaKafka(String name) {
        log.info("#sayHelloViaKafka");
        return helloToViaKafkaService.sayHello(name);
    }
}

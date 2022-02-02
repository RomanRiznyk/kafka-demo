package com.onboarding.kafkademo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloToStatic implements HelloToService {

    @Override
    public String sayHello(String name) { // todo name Optional
        if (name == null) {
            return "Hello! Plz, write your name in request.";
        }
        return hello + name + "!";
    }
}

package com.learn_spring.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunRouteNotFoundException extends RuntimeException {
    public RunRouteNotFoundException(String message){
        super(message);
    }
}

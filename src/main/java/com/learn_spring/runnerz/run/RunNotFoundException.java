package com.learn_spring.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException{

    public RunNotFoundException(){
        super("The data you are looking for does not exist.");
    }

}

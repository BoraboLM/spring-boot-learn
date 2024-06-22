package com.learn_spring.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository runRepository;

    public RunController (RunRepository runRepository){
        this.runRepository = runRepository;
    }

    // for fetching all the data and returns as a Json
    @GetMapping("")
    List<Run> findAll () {
        return runRepository.findAll();
    }

    // for fetching a single data and returns as a Json
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id){

        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new RunRouteNotFoundException("The data you are looking for does not exist.");
        }
        return run.get();
    }

    //post request
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run){
        runRepository.create(run);
    }

    //put request
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    void update (@Valid @RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);
    }

    //delete request
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete (@Valid @PathVariable Integer id){
        runRepository.delete(id);
    }
}

package com.learn_spring.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){
        return runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
        Optional<Run> existingRun = findById(id);
        if(existingRun.isEmpty()){
            throw new RunNotFoundException();
        }
        runs.set(runs.indexOf(existingRun.get()), run);
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private void init(){
    // Use to add some initial data for testing
        runs.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR));
        runs.add(new Run(2, "Wednesday Morning Run", LocalDateTime.now(), LocalDateTime.now().plus(3, ChronoUnit.HOURS), 8, Location.OUTDOOR));
        runs.add(new Run(3, "Thursday Evening Run", LocalDateTime.now(), LocalDateTime.now().plus(3, ChronoUnit.HOURS), 8, Location.OUTDOOR));
    }
}

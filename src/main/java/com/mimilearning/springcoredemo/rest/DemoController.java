package com.mimilearning.springcoredemo.rest;

import com.mimilearning.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependency
    private Coach myCoach;
    private Coach myAnotherCoach;


    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach myCoach,
                          @Qualifier("cricketCoach") Coach myAnotherCoach) {
        this.myCoach = myCoach;
        this.myAnotherCoach = myAnotherCoach;
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
        return "comparing beans : myCoach == anotherCoach  "+(myCoach==myAnotherCoach);
    }

}

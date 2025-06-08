package storybubbles.storybubbles_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import storybubbles.storybubbles_spring.model.Test;
import storybubbles.storybubbles_spring.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping
    public Test getTestById(@RequestParam long testId){
        return testService.getTestById(testId);
    } 
}

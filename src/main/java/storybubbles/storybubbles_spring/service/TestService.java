package storybubbles.storybubbles_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storybubbles.storybubbles_spring.model.Test;
import storybubbles.storybubbles_spring.repository.TestRepository;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Test getTest(Long testId) {
        return testRepository.findById(testId).orElseThrow();
    }
}

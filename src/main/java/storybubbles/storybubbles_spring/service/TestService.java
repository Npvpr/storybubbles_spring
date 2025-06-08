package storybubbles.storybubbles_spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import storybubbles.storybubbles_spring.model.Test;
import storybubbles.storybubbles_spring.repository.TestRepository;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public Test getTestById(Long testId) {
        return testRepository.findById(testId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found"));
    }

    public long countTests() {
        return testRepository.count();
    }

    public List<Test> getAllTests() {
        return testRepository.findAll();
    }
}

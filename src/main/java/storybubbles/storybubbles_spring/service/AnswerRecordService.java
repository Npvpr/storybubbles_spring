package storybubbles.storybubbles_spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storybubbles.storybubbles_spring.dto.TestAnswersDto;
import storybubbles.storybubbles_spring.model.AnswerRecord;
import storybubbles.storybubbles_spring.model.User;
import storybubbles.storybubbles_spring.repository.AnswerRecordRepository;

@Service
public class AnswerRecordService {
    @Autowired
    private AnswerRecordRepository answerRecordRepository;

    @Autowired
    private UserService userService;

    // creating answer with user that got from the client/frontend is not a good idea
    // user could be updated with wrong infos for the existing user
    // only request userId, check it and save answer for that user
    public AnswerRecord createAnswerRecord(AnswerRecord answerRecord){
        return answerRecordRepository.save(answerRecord);
    }

    public void createTestAnswers(TestAnswersDto testAnswersDto){
        User user = userService.getUserById(testAnswersDto.getUserId());
        HashMap<Long, Integer> questionsAnswers = testAnswersDto.getQuestionsAnswers();

        questionsAnswers.forEach((questionId, answerIndex) -> {
            answerRecordRepository.save(new AnswerRecord(questionId, answerIndex, user));
        });
    }
}

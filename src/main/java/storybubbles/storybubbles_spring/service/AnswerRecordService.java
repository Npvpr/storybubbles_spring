package storybubbles.storybubbles_spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storybubbles.storybubbles_spring.model.AnswerRecord;
import storybubbles.storybubbles_spring.repository.AnswerRecordRepository;

@Service
public class AnswerRecordService {
    @Autowired
    private AnswerRecordRepository answerRecordRepository;

    public AnswerRecord addAnswerRecord(AnswerRecord answerRecord){
        return answerRecordRepository.save(answerRecord);
    }
}

package storybubbles.storybubbles_spring.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import storybubbles.storybubbles_spring.model.AnswerRecord;
import storybubbles.storybubbles_spring.repository.AnswerRecordRepository;

@ExtendWith(MockitoExtension.class)
public class AnswerRecordServiceTest {

    @Mock
    AnswerRecordRepository answerRecordRepository;

    @InjectMocks
    AnswerRecordService answerRecordService;

    AnswerRecord answerRecord = new AnswerRecord();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAnswerRecordByUserIdQuestionID_found() {
        // when(answerRecordRepository.findByUserIdAndQuestionId(userId, questionId))
        // .thenReturn(Optional.of(answerRecord));
        UUID userId = UUID.randomUUID();
        Long questionId = 1L;
        int chosenAnswer = 1;

        AnswerRecord answerRecord = answerRecordService
                .createAnswerRecord(new AnswerRecord(userId, questionId, chosenAnswer));
        AnswerRecord result = answerRecordService.getAnswerRecordByUserIdQuestionID(userId, questionId);

        System.out.println("Found answerRecord: " + answerRecord);
        System.out.println("Found result: " + result);

        assertEquals(answerRecord, result);
    }

    @Test
    void getAnswerRecordByUserIdQuestionID_notFound() {

        UUID userId = UUID.randomUUID();
        Long questionId = 1L;
        int chosenAnswer = 1;

        when(answerRecordRepository.findByUserIdAndQuestionId(userId, questionId))
                .thenReturn(Optional.empty());

        AnswerRecord result = answerRecordService.getAnswerRecordByUserIdQuestionID(userId, questionId);
        System.out.println("Not found answerRecord: " + answerRecord);
        System.out.println("Not found result: " + result);

        assertEquals(result, null);
    }
}
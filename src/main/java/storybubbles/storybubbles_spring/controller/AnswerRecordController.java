package storybubbles.storybubbles_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storybubbles.storybubbles_spring.dto.TestAnswersDto;
import storybubbles.storybubbles_spring.model.AnswerRecord;
import storybubbles.storybubbles_spring.service.AnswerRecordService;

@RestController
@RequestMapping("/answer")
public class AnswerRecordController {

    @Autowired
    private AnswerRecordService answerRecordService;

    @PostMapping
    public AnswerRecord createAnswerRecord(@RequestBody AnswerRecord answerRecord){
        return answerRecordService.createAnswerRecord(answerRecord);
    }

    @PostMapping("/test-answers")
    public ResponseEntity<String> createTestAnswers(@RequestBody TestAnswersDto testAnswersDto){
        answerRecordService.createTestAnswers(testAnswersDto);
        return new ResponseEntity<>("Test Answers recorded!", HttpStatus.CREATED);
    }
}

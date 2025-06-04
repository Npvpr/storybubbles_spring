package storybubbles.storybubbles_spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import storybubbles.storybubbles_spring.dto.StoryAnswersRequest;
import storybubbles.storybubbles_spring.dto.StoryAnswersResponse;
import storybubbles.storybubbles_spring.dto.StoryWithScenesResponse;
import storybubbles.storybubbles_spring.dto.TestAnswersDto;
import storybubbles.storybubbles_spring.model.*;
import storybubbles.storybubbles_spring.repository.AnswerRecordRepository;

@Service
public class AnswerRecordService {
    @Autowired
    private AnswerRecordRepository answerRecordRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private StoryService storyService;

    // creating answer with user that got from the client/frontend is not a good
    // idea
    // user could be updated with wrong infos for the existing user
    // only request userId, check it and save answer for that user
    public AnswerRecord createAnswerRecord(AnswerRecord answerRecord) {
        return answerRecordRepository.save(answerRecord);
    }

    public void createTestAnswers(TestAnswersDto testAnswersDto) {
        UUID userId = testAnswersDto.getUserId();
        HashMap<Long, Integer> questionsAnswers = testAnswersDto.getQuestionsAnswers();

        questionsAnswers.forEach((questionId, answerIndex) -> {
            answerRecordRepository.save(new AnswerRecord(userId, questionId, answerIndex));
        });
    }

    public AnswerRecord getAnswerRecordByUserIdQuestionID(UUID userId, Long questionId) {
        return answerRecordRepository.findByUserIdAndQuestionId(userId, questionId)
                .orElse(null);
    }

    public StoryAnswersResponse countStoryAnswers(StoryAnswersRequest storyAnswersRequest) {
        Long storyId = storyAnswersRequest.getStoryId();
        StoryWithScenesResponse storyWithScenes = storyService.getStoryWithScenesById(storyId);
        UUID userId = storyAnswersRequest.getUserId();

        List<HashMap<String, String>> storyAnswersList = new ArrayList<>();
        // AtomicInteger workaround for Java Lambda's Effectively Final rule
        AtomicInteger correctCount = new AtomicInteger(0);

        // for each scene of the story
        storyWithScenes.getScenes().forEach((scene) -> {

            List<Question> questions = scene.getQuestions();

            // for each question of the scene
            // each scene can have min 0 to max 2 questions
            if (questions != null) {
                questions.forEach((question) -> {

                    HashMap<String, String> textHashMap = new HashMap<>();

                    // get question text
                    textHashMap.put("questionText", question.getQuestionText());

                    // get correct answer text from question
                    int correctAnswerIndex = question.getCorrectAnswerIndex();
                    // System.out.println("CorrectAnswerIndex: " + correctAnswerIndex);
                    textHashMap.put("correctAnswerText",
                            question.getChoices().get(correctAnswerIndex).getLabel());

                    // get answer text
                    int userAnswerIndex = -1;

                    AnswerRecord answerRecord = getAnswerRecordByUserIdQuestionID(userId, question.getId());

                    if (answerRecord == null) {
                        // if user hasn't answered the question
                        // System.out.println("Answer Record is null!");
                        textHashMap.put("userAnswerText", "Not Answered");
                    } else {
                        // if user has answered the question
                        // System.out.println("Answer Record is not null!");

                        userAnswerIndex = answerRecord.getChosenAnswer();

                        textHashMap.put("userAnswerText",
                                question.getChoices().get(userAnswerIndex)
                                        .getLabel());
                    }

                    // check if the user's answer is correct
                    if (correctAnswerIndex == userAnswerIndex) {
                        textHashMap.put("correct", "true");
                        correctCount.incrementAndGet();
                    } else {
                        textHashMap.put("correct", "false");
                    }

                    // add the hashmap to the list
                    storyAnswersList.add(textHashMap);
                });
            }
        });
        return new StoryAnswersResponse(storyAnswersList, correctCount.get());
    }
}

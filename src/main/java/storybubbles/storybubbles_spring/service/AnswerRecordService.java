package storybubbles.storybubbles_spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storybubbles.storybubbles_spring.dto.StoryAnswersDTO;
import storybubbles.storybubbles_spring.dto.StoryWithScenesResponse;
import storybubbles.storybubbles_spring.dto.TestAnswersDto;
import storybubbles.storybubbles_spring.dto.UserAllAnswersDTO;
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

    @Autowired
    private TestService testService;

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

    public StoryAnswersDTO getStoryAnswers(UUID userId, Long storyId) {

        StoryWithScenesResponse storyWithScenes = storyService.getStoryWithScenesById(storyId);

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
        return new StoryAnswersDTO(storyAnswersList, correctCount.get());
    }

    // what if user doesn't exist?
    // what if test doesn't exist?
    public List<HashMap<String, String>> getTestAnswers(UUID userId, Long testId) {
        List<HashMap<String, String>> testAnswers = new ArrayList<>();

        Test test = testService.getTestById(testId);
        test.getQuestions().forEach((question) -> {
            HashMap<String, String> textHashMap = new HashMap<>();

            textHashMap.put("questionText", question.getQuestionText());

            int userAnswerIndex = -1;
            AnswerRecord answerRecord = getAnswerRecordByUserIdQuestionID(userId, question.getId());

            if (answerRecord == null) {
                // user not answered yet
                textHashMap.put("userAnswerText", "Not Answered");
            } else {
                userAnswerIndex = answerRecord.getChosenAnswer();
                textHashMap.put("userAnswerText", question.getChoices().get(userAnswerIndex).getLabel());
            }

            testAnswers.add(textHashMap);

        });

        return testAnswers;
    }

    public List<UserAllAnswersDTO> getAllAnswers() {

        List<UserAllAnswersDTO> allUsers = new ArrayList<>();

        userService.getAllUsers().forEach((user) -> {
            UUID userId = user.getId();
            AtomicInteger totalCorrectCount = new AtomicInteger(0);

            List<List<HashMap<String, String>>> userTests = new ArrayList<>();

            testService.getAllTests().forEach((test) -> {
                userTests.add(getTestAnswers(userId, test.getId()));
            });

            List<StoryAnswersDTO> userStories = new ArrayList<>();

            storyService.getAllStories().forEach((story) -> {
                StoryAnswersDTO storyAnswersDTO = getStoryAnswers(userId, story.getId());
                userStories.add(storyAnswersDTO);
                totalCorrectCount.addAndGet(storyAnswersDTO.getCorrectCount());
            });

            allUsers.add(new UserAllAnswersDTO(userTests, userStories, totalCorrectCount.get()));
        });

        return allUsers;
    }
}

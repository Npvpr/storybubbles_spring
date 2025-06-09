package storybubbles.storybubbles_spring.config;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import storybubbles.storybubbles_spring.model.*;
import storybubbles.storybubbles_spring.repository.ChoiceRepository;
import storybubbles.storybubbles_spring.repository.QuestionRepository;
import storybubbles.storybubbles_spring.repository.SceneRepository;
import storybubbles.storybubbles_spring.repository.StoryRepository;
import storybubbles.storybubbles_spring.repository.TestRepository;

@Component
public class DbInit {

        @Autowired
        private StoryRepository storyRepository;

        @Autowired
        private SceneRepository sceneRepository;

        @Autowired
        private QuestionRepository questionRepository;

        @Autowired
        private TestRepository testRepository;

        @Autowired
        private ChoiceRepository choiceRepository;

        @Autowired
        DataSource dataSource;

        @PostConstruct
        private void postConstruct() throws SQLException {
                // DB Test (31 -> red)
                System.out.println("\u001B[33mJDBC URL: " + dataSource.getConnection().getMetaData().getURL());

                // Pretest
                List<Question> preTestQuestions = new ArrayList<>();

                preTestQuestions.add(questionRepository.save(new Question(
                                "How much fun did you have playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "How interested were you in the story of the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "How motivated were you to keep playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Did you feel proud when you completed a level or challenge?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Was the game too easy, too hard, or just right for you?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "How good did you feel after finishing a tough task or puzzle?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Did you learn something new while playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Would you want to play this game again?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "How much did you like the characters in the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Did getting rewards (like points or new levels) make you want to keep playing?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                Test preTest = new Test(
                                1L,
                                preTestQuestions);
                testRepository.save(preTest);

                // Posttest
                List<Question> postTestQuestions = new ArrayList<>();

                postTestQuestions.add(questionRepository.save(new Question(
                                "How much fun did you have playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "How interested were you in the story of the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "How motivated were you to keep playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Did you feel proud when you completed a level or challenge?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Was the game too easy, too hard, or just right for you?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "How good did you feel after finishing a tough task or puzzle?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Did you learn something new while playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Would you want to play this game again?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "How much did you like the characters in the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Did getting rewards (like points or new levels) make you want to keep playing?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Strongly Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "Disagree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Neutral")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Agree")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Strongly Agree"))))));

                Test postTest = new Test(
                                2L,
                                postTestQuestions);
                testRepository.save(postTest);

                // Story 1
                Story story1 = storyRepository.save(new Story(1L, "The Forest", "/sounds/story1/titleSound.mp3",
                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/bgMusic.mp3"));

                sceneRepository.save(new Scene("Milo's Adventure", story1, List.of(
                                "Milo, the friendly boy, lived in a colorful forest filled with magical creatures.",
                                "Unlike the other monsters, Milo loved exploring, learning new words, and helping his friends."),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene1Sound1.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene1Sound2.mp3"),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Introduction.png")));

                sceneRepository.save(new Scene(
                                "The Lost Book",
                                story1,
                                List.of(
                                                "Milo was playing alone in the forest when he heard a crying voice coming from the direction of the sun.",
                                                "He followed the sound and met a crying squirrel named Sammy.",
                                                "Sammy said he lost his favorite book of words. He had fallen asleep near something with leaves and a book, and when he woke up, the book was gone.",
                                                "Milo decided to help Sammy find the book."),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene2Sound1.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene2Sound2.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene2Sound3.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene2Sound4.mp3"),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene1.png"),
                                List.of(
                                                questionRepository.save(new Question(
                                                                "Milo heard a crying voice coming from the direction of the sun. Which direction does the sun rise from?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/north.gif",
                                                                                                                "North")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/east.gif",
                                                                                                                "East")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/south.gif",
                                                                                                                "South")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/west.gif",
                                                                                                                "West"))),
                                                                1)),
                                                questionRepository.save(new Question("What’s something with leaves?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/river+flow.gif",
                                                                                                                "River")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/cave.gif",
                                                                                                                "Cave")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/house.gif",
                                                                                                                "House")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/tree.gif",
                                                                                                                "Tree"))),
                                                                3)))));

                sceneRepository.save(new Scene(
                                "The Talking Tree",
                                story1,
                                List.of(
                                                "Milo and Sammy met a wise, talking tree named Tilda.",
                                                "Tilda knew a lot of words and offered to give them clues to find the book. But first, they needed to solve her riddles."),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene3Sound1.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene3Sound2.mp3"),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene2.png"),
                                List.of(
                                                questionRepository.save(new Question(
                                                                "I’m yellow and I peel, you can eat me as a snack. I grow on a tall, green plant. What am I?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/banana.gif",
                                                                                                                "Banana")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/apple.gif",
                                                                                                                "Apple")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/leaf.gif",
                                                                                                                "Leaf")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/stick.gif",
                                                                                                                "Stick"))),
                                                                0)),
                                                questionRepository.save(new Question(
                                                                "I grow on trees, but I’m not a leaf. What am I?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/rock.gif",
                                                                                                                "Rock")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/fruit.gif",
                                                                                                                "Fruit")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/feather.gif",
                                                                                                                "Feather")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/water.gif",
                                                                                                                "Water"))),
                                                                1)))));

                sceneRepository.save(new Scene(
                                "The River of Rhymes",
                                story1,
                                List.of(
                                                "The next clue led Milo and Sammy to a river.",
                                                "They had to cross it, but the only way was by completing rhyme challenges given by a playful Fish."),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene4Sound1.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene4Sound2.mp3"),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene3.png"),
                                List.of(
                                                questionRepository.save(new Question(
                                                                "What does the river do with the stream? It rhymes with 'row'.",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/flood.gif",
                                                                                                                "Flood")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/float.gif",
                                                                                                                "Float")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/river+flow.gif",
                                                                                                                "Flow")),

                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/fly.gif",
                                                                                                                "Fly"))),
                                                                2)),
                                                questionRepository.save(new Question(
                                                                "How did the book travel through the river stream? It rhymes with 'boat'.",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/float.gif",
                                                                                                                "Float")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/flood.gif",
                                                                                                                "Flood")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/fly.gif",
                                                                                                                "Fly")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/flower.gif",
                                                                                                                "Flower"))),
                                                                0)))));

                sceneRepository.save(new Scene(
                                "The Hidden Cave",
                                story1,
                                List.of(
                                                "Finally, Milo and Sammy reached a hidden cave.",
                                                "Inside, they found the book, guarded by a sleepy dragon who loved stories.",
                                                "The dragon would only let them take the book if they read him a story about kings and knights."),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene5Sound1.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene5Sound2.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene5Sound3.mp3"),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene4.png"),
                                List.of(
                                                questionRepository.save(new Question(
                                                                "Where do kings and knights live?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/river+flow.gif",
                                                                                                                "River")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/forest.gif",
                                                                                                                "Forest")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/cave.gif",
                                                                                                                "Cave")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/castle.gif",
                                                                                                                "Castle"))),
                                                                3)),
                                                questionRepository.save(new Question(
                                                                "Which weapons do kings and knights use to fight?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/sword.gif",
                                                                                                                "Sword")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/spoon.gif",
                                                                                                                "Spoon")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/rope.gif",
                                                                                                                "Rope")),
                                                                                choiceRepository.save(
                                                                                                new Choice("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/torch.gif",
                                                                                                                "Torch"))),
                                                                0)))));

                sceneRepository.save(new Scene(
                                "The Magic of Words",
                                story1,
                                List.of(
                                                "Milo and Sammy ran out of the cave, laughing and holding the book tight.",
                                                "Sammy (hugging the book): 'We did it! I thought I’d never see my book again.'",
                                                "Milo (grinning): 'Let’s open it and see what story is inside!'",
                                                "Sammy flipped open the book… but suddenly, a golden light swirled around them!",
                                                "The pages glowed, and before they could say another word—WHOOSH!—they were sucked into the book!"),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene6Sound1.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene6Sound2.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene6Sound3.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene6Sound4.mp3",
                                                "https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene6Sound5.mp3"),
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Conclusion.png")));

        }

}

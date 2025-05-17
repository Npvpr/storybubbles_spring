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
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif",
                                                                "Not fun at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f611/512.gif",
                                                                "A little fun")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Somewhat fun")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Fun")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Very fun"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "How interested were you in the story of the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f634/512.gif",
                                                                "Not interested at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "A little interested")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif",
                                                                "Somewhat interested")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60d/512.gif",
                                                                "Interested")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f632/512.gif",
                                                                "Very interested"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "How motivated were you to keep playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f62b/512.gif",
                                                                "Not motivated at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60c/512.gif",
                                                                "A little motivated")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60f/512.gif",
                                                                "Somewhat motivated")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60e/512.gif",
                                                                "Motivated")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f4aa/512.gif",
                                                                "Very motivated"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Did you feel proud when you completed a level or challenge?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif",
                                                                "Not proud at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "A little proud")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Somewhat proud")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f601/512.gif",
                                                                "Proud")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60e/512.gif",
                                                                "Very proud"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Was the game too easy, too hard, or just right for you?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f613/512.gif",
                                                                "Too easy")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "A little too easy")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60c/512.gif",
                                                                "Just right")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f624/512.gif",
                                                                "A little too hard")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f629/512.gif",
                                                                "Too hard"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "How good did you feel after finishing a tough task or puzzle?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif",
                                                                "Not good at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "A little good")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Somewhat good")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Good")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f31f/512.gif",
                                                                "Very good"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Did you learn something new while playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Not at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "A little")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif",
                                                                "Somewhat")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f4a1/512.gif",
                                                                "Yes")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f31f/512.gif",
                                                                "A lot"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Would you want to play this game again?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Not at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif",
                                                                "Maybe a little")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "I don’t know")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Yes")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60d/512.gif",
                                                                "Definitely"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "How much did you like the characters in the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Didn’t like them at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Liked them a little")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Liked them somewhat")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f603/512.gif",
                                                                "Liked them")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/2764_fe0f/512.gif",
                                                                "Loved them"))))));

                preTestQuestions.add(questionRepository.save(new Question(
                                "Did getting rewards (like points or new levels) make you want to keep playing?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Not at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "A little bit")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Somewhat")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f603/512.gif",
                                                                "Yes")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f389/512.gif",
                                                                "Definitely"))))));

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
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif",
                                                                "Not fun at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f611/512.gif",
                                                                "A little fun")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Somewhat fun")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Fun")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif",
                                                                "Very fun"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "How interested were you in the story of the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f634/512.gif",
                                                                "Not interested at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "A little interested")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif",
                                                                "Somewhat interested")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60d/512.gif",
                                                                "Interested")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f632/512.gif",
                                                                "Very interested"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "How motivated were you to keep playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f62b/512.gif",
                                                                "Not motivated at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60c/512.gif",
                                                                "A little motivated")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60f/512.gif",
                                                                "Somewhat motivated")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60e/512.gif",
                                                                "Motivated")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f4aa/512.gif",
                                                                "Very motivated"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Did you feel proud when you completed a level or challenge?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif",
                                                                "Not proud at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "A little proud")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Somewhat proud")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f601/512.gif",
                                                                "Proud")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60e/512.gif",
                                                                "Very proud"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Was the game too easy, too hard, or just right for you?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f613/512.gif",
                                                                "Too easy")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "A little too easy")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60c/512.gif",
                                                                "Just right")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f624/512.gif",
                                                                "A little too hard")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f629/512.gif",
                                                                "Too hard"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "How good did you feel after finishing a tough task or puzzle?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif",
                                                                "Not good at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                                                "A little good")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Somewhat good")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif",
                                                                "Good")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f31f/512.gif",
                                                                "Very good"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Did you learn something new while playing the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Not at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "A little")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif",
                                                                "Somewhat")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f4a1/512.gif",
                                                                "Yes")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f31f/512.gif",
                                                                "A lot"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Would you want to play this game again?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Not at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif",
                                                                "Maybe a little")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "I don’t know")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Yes")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f60d/512.gif",
                                                                "Definitely"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "How much did you like the characters in the game?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Didn’t like them at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "Liked them a little")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Liked them somewhat")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f603/512.gif",
                                                                "Liked them")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/2764_fe0f/512.gif",
                                                                "Loved them"))))));

                postTestQuestions.add(questionRepository.save(new Question(
                                "Did getting rewards (like points or new levels) make you want to keep playing?",
                                List.of(
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                                                "Not at all")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                                                "A little bit")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                                                "Somewhat")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f603/512.gif",
                                                                "Yes")),
                                                choiceRepository.save(new Choice(
                                                                "https://fonts.gstatic.com/s/e/notoemoji/latest/1f389/512.gif",
                                                                "Definitely"))))));

                Test postTest = new Test(
                                2L,
                                postTestQuestions);
                testRepository.save(postTest);

                // Story 1
                Story story1 = storyRepository.save(new Story(1L, "The Forest","/sounds/story1/titleSound.mp3", "/sounds/story1/bgMusic.mp3"));

                sceneRepository.save(new Scene("Milo's Adventure", story1, List.of(
                                "Milo, the friendly boy, lived in a colorful forest filled with magical creatures.",
                                "Unlike the other monsters, Milo loved exploring, learning new words, and helping his friends."),
                                "/sounds/story1/introSound.mp3",
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Introduction.png")));

                sceneRepository.save(new Scene(
                                "The Lost Book",
                                story1,
                                List.of(
                                                "Milo was playing alone in the forest when he heard a crying voice coming from the direction of the sun.",
                                                "He followed the sound and met a crying squirrel named Sammy.",
                                                "Sammy said he lost his favorite book of words. He had fallen asleep near something with leaves and a book, and when he woke up, the book was gone.",
                                                "Milo decided to help Sammy find the book."),
                                "/sounds/story1/scene1.mp3",
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene1.png"),
                                List.of(
                                                questionRepository.save(new Question(
                                                                "Milo heard a crying voice coming from the direction of the sun. Which direction does the sun rise from?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("North")),
                                                                                choiceRepository.save(
                                                                                                new Choice("East")),
                                                                                choiceRepository.save(
                                                                                                new Choice("South")),
                                                                                choiceRepository.save(
                                                                                                new Choice("West"))),
                                                                2)),
                                                questionRepository.save(new Question("What’s something with leaves?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("River")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Cave")),
                                                                                choiceRepository.save(
                                                                                                new Choice("House")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Tree"))),
                                                                4)))));

                sceneRepository.save(new Scene(
                                "The Talking Tree",
                                story1,
                                List.of(
                                                "Milo and Sammy met a wise, talking tree named Tilda.",
                                                "Tilda knew a lot of words and offered to give them clues to find the book. But first, they needed to solve her riddles."),
                                "/sounds/story1/scene2.mp3",
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene2.png"),
                                List.of(
                                                questionRepository.save(new Question(
                                                                "I’m yellow and I peel, you can eat me as a snack. I grow on a tall, green plant. What am I?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("Banana")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Apple")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Leaf")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Stick"))),
                                                                1)),
                                                questionRepository.save(new Question(
                                                                "I grow on trees, but I’m not a leaf. What am I?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("Fruit")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Rock")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Feather")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Water"))),
                                                                1)))));

                sceneRepository.save(new Scene(
                                "The River of Rhymes",
                                story1,
                                List.of(
                                                "The next clue led Milo and Sammy to a river.",
                                                "They had to cross it, but the only way was by completing rhyme challenges given by a playful Fish."),
                                "/sounds/story1/scene3.mp3",
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene3.png"),
                                List.of(
                                                questionRepository.save(new Question(
                                                                "What does the river do with the stream? It rhymes with 'row'.",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("Flow")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Flood")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Float")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Fly"))),
                                                                1)),
                                                questionRepository.save(new Question(
                                                                "How did the book travel through the river stream? It rhymes with 'boat'.",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("Float")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Flood")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Fly")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Flower"))),
                                                                1)))));

                sceneRepository.save(new Scene(
                                "The Hidden Cave",
                                story1,
                                List.of(
                                                "Finally, Milo and Sammy reached a hidden cave.",
                                                "Inside, they found the book, guarded by a sleepy dragon who loved stories.",
                                                "The dragon would only let them take the book if they read him a story about kings and knights."),
                                "/sounds/story1/scene4.mp3",
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Scene4.png"),
                                List.of(
                                                questionRepository.save(new Question(
                                                                "Where do kings and knights live?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("Castle")),
                                                                                choiceRepository.save(
                                                                                                new Choice("River")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Forest")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Cave"))),
                                                                1)),
                                                questionRepository.save(new Question(
                                                                "Which weapons do kings and knights use to fight?",
                                                                List.of(
                                                                                choiceRepository.save(
                                                                                                new Choice("Sword")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Spoon")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Rope")),
                                                                                choiceRepository.save(
                                                                                                new Choice("Torch"))),
                                                                1)))));

                sceneRepository.save(new Scene(
                                "The Magic of Words",
                                story1,
                                List.of(
                                                "Milo and Sammy ran out of the cave, laughing and holding the book tight.",
                                                "Sammy (hugging the book): 'We did it! I thought I’d never see my book again.'",
                                                "Milo (grinning): 'Let’s open it and see what story is inside!'",
                                                "Sammy flipped open the book… but suddenly, a golden light swirled around them!",
                                                "The pages glowed, and before they could say another word—WHOOSH!—they were sucked into the book!"),
                                "/sounds/story1/conclusion.mp3",
                                List.of("https://s3.eu-west-2.amazonaws.com/nlm.aws.storybubbles/Story+1/Conclusion.png")));

        }

}

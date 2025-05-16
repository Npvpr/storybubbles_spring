package storybubbles.storybubbles_spring.config;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println("\u001B[31mJDBC URL: " + dataSource.getConnection().getMetaData().getURL());
        // Spring will select the id first before inserting to escape duplicates
        // Save story first
        Story story1 = new Story(1L, "The Lost Dragon");
        storyRepository.save(story1);

        // Save question
        Question question1 = new Question(

                "What color was the dragon?",
                List.of(choiceRepository.save(new Choice("Red")),
                        choiceRepository.save(new Choice("Blue")),
                        choiceRepository.save(new Choice("Green")),
                        choiceRepository.save(new Choice("Yellow"))),
                2);
        questionRepository.save(question1);

        // Save scene with that story and question
        Scene scene1 = new Scene(
                1L,
                story1,
                List.of("The dragon soared into the sky.", "It vanished behind the clouds."),
                List.of("dragon-flying.png", "clouds.png"),
                question1);
        sceneRepository.save(scene1);

        // Pretest
        List<Question> preTestQuestions = new ArrayList<>();

        preTestQuestions.add(questionRepository.save(new Question(
                "How much fun did you have playing the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif", "Not fun at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f611/512.gif", "A little fun")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Somewhat fun")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif", "Fun")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif", "Very fun"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "How interested were you in the story of the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f634/512.gif",
                                "Not interested at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                "A little interested")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif",
                                "Somewhat interested")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60d/512.gif", "Interested")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f632/512.gif",
                                "Very interested"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "How motivated were you to keep playing the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f62b/512.gif",
                                "Not motivated at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60c/512.gif",
                                "A little motivated")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60f/512.gif",
                                "Somewhat motivated")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60e/512.gif", "Motivated")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f4aa/512.gif",
                                "Very motivated"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Did you feel proud when you completed a level or challenge?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif", "Not proud at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif", "A little proud")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Somewhat proud")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f601/512.gif", "Proud")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60e/512.gif", "Very proud"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Was the game too easy, too hard, or just right for you?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f613/512.gif", "Too easy")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif", "A little too easy")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60c/512.gif", "Just right")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f624/512.gif", "A little too hard")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f629/512.gif", "Too hard"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "How good did you feel after finishing a tough task or puzzle?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif", "Not good at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif", "A little good")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Somewhat good")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif", "Good")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f31f/512.gif", "Very good"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Did you learn something new while playing the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif", "Not at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "A little")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif", "Somewhat")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f4a1/512.gif", "Yes")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f31f/512.gif", "A lot"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Would you want to play this game again?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif", "Not at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif", "Maybe a little")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif", "I don’t know")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Yes")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60d/512.gif", "Definitely"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "How much did you like the characters in the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                "Didn’t like them at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                "Liked them a little")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                "Liked them somewhat")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f603/512.gif", "Liked them")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/2764_fe0f/512.gif",
                                "Loved them"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Did getting rewards (like points or new levels) make you want to keep playing?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif", "Not at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif", "A little bit")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Somewhat")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f603/512.gif", "Yes")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f389/512.gif", "Definitely"))))));

        Test preTest = new Test(
                1L,
                preTestQuestions);
        testRepository.save(preTest);

         // Posttest
        List<Question> postTestQuestions = new ArrayList<>();

        preTestQuestions.add(questionRepository.save(new Question(
                "How much fun did you have playing the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif", "Not fun at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f611/512.gif", "A little fun")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Somewhat fun")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif", "Fun")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f929/512.gif", "Very fun"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "How interested were you in the story of the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f634/512.gif",
                                "Not interested at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif",
                                "A little interested")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif",
                                "Somewhat interested")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60d/512.gif", "Interested")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f632/512.gif",
                                "Very interested"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "How motivated were you to keep playing the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f62b/512.gif",
                                "Not motivated at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60c/512.gif",
                                "A little motivated")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60f/512.gif",
                                "Somewhat motivated")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60e/512.gif", "Motivated")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f4aa/512.gif",
                                "Very motivated"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Did you feel proud when you completed a level or challenge?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif", "Not proud at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif", "A little proud")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Somewhat proud")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f601/512.gif", "Proud")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60e/512.gif", "Very proud"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Was the game too easy, too hard, or just right for you?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f613/512.gif", "Too easy")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif", "A little too easy")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60c/512.gif", "Just right")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f624/512.gif", "A little too hard")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f629/512.gif", "Too hard"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "How good did you feel after finishing a tough task or puzzle?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f614/512.gif", "Not good at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f615/512.gif", "A little good")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Somewhat good")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f604/512.gif", "Good")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f31f/512.gif", "Very good"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Did you learn something new while playing the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif", "Not at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "A little")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif", "Somewhat")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f4a1/512.gif", "Yes")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f31f/512.gif", "A lot"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Would you want to play this game again?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif", "Not at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f914/512.gif", "Maybe a little")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif", "I don’t know")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Yes")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f60d/512.gif", "Definitely"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "How much did you like the characters in the game?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif",
                                "Didn’t like them at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif",
                                "Liked them a little")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif",
                                "Liked them somewhat")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f603/512.gif", "Liked them")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/2764_fe0f/512.gif",
                                "Loved them"))))));

        preTestQuestions.add(questionRepository.save(new Question(
                "Did getting rewards (like points or new levels) make you want to keep playing?",
                List.of(
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f61e/512.gif", "Not at all")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f610/512.gif", "A little bit")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f642/512.gif", "Somewhat")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f603/512.gif", "Yes")),
                        choiceRepository.save(new Choice("https://fonts.gstatic.com/s/e/notoemoji/latest/1f389/512.gif", "Definitely"))))));


        Test postTest = new Test(
                2L,
                postTestQuestions);
        testRepository.save(postTest);

    }

}

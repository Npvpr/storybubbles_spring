package storybubbles.storybubbles_spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import storybubbles.storybubbles_spring.model.Question;
import storybubbles.storybubbles_spring.model.Scene;
import storybubbles.storybubbles_spring.model.Story;
import storybubbles.storybubbles_spring.repository.QuestionRepository;
import storybubbles.storybubbles_spring.repository.SceneRepository;
import storybubbles.storybubbles_spring.repository.StoryRepository;

@Component
public class DbInit {
 
    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private SceneRepository sceneRepository;

    @Autowired
    private QuestionRepository questionRepository;
 
    @PostConstruct
    private void postConstruct() {
        // Spring will select the id first before inserting to escape duplicates
        // Save story first
        Story story1 = new Story(1L, "The Lost Dragon");
        storyRepository.save(story1);

        // Save question
        Question question1 = new Question(
            1L,
            "What color was the dragon?",
            Arrays.asList("Red", "Blue", "Green", "Black"),
            2
        );
        questionRepository.save(question1);

        // Save scene with that story and question
        Scene scene1 = new Scene(
            1L,
            story1,
            Arrays.asList("The dragon soared into the sky.", "It vanished behind the clouds."),
            Arrays.asList("dragon-flying.png", "clouds.png"),
            question1
        );
        sceneRepository.save(scene1);

    }
}

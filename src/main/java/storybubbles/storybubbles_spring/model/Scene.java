package storybubbles.storybubbles_spring.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scenes")
@Getter
@NoArgsConstructor
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    private List<String> dialogues;
    private List<String> dialogueSounds;
    private List<String> pictures;

    // Cannot make ManyToOne from Question because not all questions are part of a
    // scene, some are part of the tests
    @OneToMany
    private List<Question> questions;

    public Scene(String name, Story story, List<String> dialogues, List<String> dialogueSounds, List<String> pictures, List<Question> questions){
        this.name = name;
        this.story = story;
        this.dialogues = dialogues;
        this.dialogueSounds = dialogueSounds;
        this.pictures = pictures;
        this.questions = questions;
    }

    // intro and conclusion scenes include no questions
    public Scene(String name, Story story, List<String> dialogues, List<String> dialogueSounds, List<String> pictures){
        this(name, story, dialogues, dialogueSounds, pictures, null);
    }
}

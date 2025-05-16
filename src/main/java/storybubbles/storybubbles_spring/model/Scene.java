package storybubbles.storybubbles_spring.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scenes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Scene {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;

    private List<String> dialogues;
    private List<String> pictures;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

}

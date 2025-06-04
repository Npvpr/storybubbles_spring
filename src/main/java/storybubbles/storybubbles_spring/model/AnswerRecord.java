package storybubbles.storybubbles_spring.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "answer_records")
@Getter
@NoArgsConstructor
public class AnswerRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID userId;

    private Long questionId; // Which question was answered?

    private int chosenAnswer; // e.g., 3 (for 1-5 surveys) or 2 (for 1-4 story choices)

    public AnswerRecord(UUID userId, Long questionId, int chosenAnswer) {
        this.userId = userId;
        this.questionId = questionId;
        this.chosenAnswer = chosenAnswer;
    }

}

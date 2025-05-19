package storybubbles.storybubbles_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    private Long  questionId; // Which question was answered?

    private int chosenAnswer; // e.g., 3 (for 1-5 surveys) or 2 (for 1-4 story choices)

    @ManyToOne
    // name can be anything
    @JoinColumn(name = "user_id")
    private User user;

    public AnswerRecord(Long questionId, int chosenAnswer, User user){
        this.questionId = questionId;
        this.chosenAnswer = chosenAnswer;
        this.user = user;
    }

}

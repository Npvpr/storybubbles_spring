package storybubbles.storybubbles_spring.model;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
// SQL is case insensitive
@Table(name = "answer_records")
@Getter
@RequiredArgsConstructor
public class AnswerRecord {

    @Id
    @UuidGenerator
    private UUID id;

    private final int questionId; // Which question was answered?

    private final int chosenAnswer; // e.g., 3 (for 1-5 surveys) or 2 (for 1-4 story choices)

    @ManyToOne
    // name can be anything
    @JoinColumn(name = "user_id")
    private final User user;

}

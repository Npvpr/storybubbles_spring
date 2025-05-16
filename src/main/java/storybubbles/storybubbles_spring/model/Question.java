package storybubbles.storybubbles_spring.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@Getter
@NoArgsConstructor
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String questionText;

  @OneToMany
  private List<Choice> choices; // 4 options for story questions
  private int correctAnswerIndex; // e.g., 0 = first choice

  public Question(String questionText, List<Choice> choices, int correctAnswerIndex) {
    this.questionText = questionText;
    this.choices = choices;
    this.correctAnswerIndex = correctAnswerIndex;
  }
  // no correct answer
  public Question(String questionText, List<Choice> choices) {
    this(questionText, choices, -1);
  }

}

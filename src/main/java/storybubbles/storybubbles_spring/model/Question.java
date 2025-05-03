package storybubbles.storybubbles_spring.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
  
  @Id
  private Long id;
  private String questionText;
  private List<String> choices; // 4 options for story questions
  private int correctAnswerIndex; // e.g., 0 = first choice

}

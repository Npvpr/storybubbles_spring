package storybubbles.storybubbles_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Check main general comments here
@Entity
@Table(name = "stories")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Story {

  @Id
  private long id;

  private String name;

}

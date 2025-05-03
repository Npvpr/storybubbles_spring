package storybubbles.storybubbles_spring.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.UuidGenerator;

// Check main general comments here
@Entity
@Table(name = "stories")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Story {

  @Id
  @UuidGenerator
  private UUID id;

  private int storyNumber;

  private String name;

}

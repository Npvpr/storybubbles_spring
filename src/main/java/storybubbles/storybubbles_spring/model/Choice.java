package storybubbles.storybubbles_spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "choices")
@Getter
@NoArgsConstructor
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emoji;
    private String label;

    public Choice(String emoji, String label) {
        this.emoji = emoji;
        this.label = label;
    }

    public Choice(String label){
        this(null, label);
    }
}

package storybubbles.storybubbles_spring.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tests")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    @Id
    private long id;

    @OneToMany
    private List<Question> questions;
}

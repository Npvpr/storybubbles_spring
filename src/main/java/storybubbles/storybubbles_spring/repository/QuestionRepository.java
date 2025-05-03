package storybubbles.storybubbles_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import storybubbles.storybubbles_spring.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    
}

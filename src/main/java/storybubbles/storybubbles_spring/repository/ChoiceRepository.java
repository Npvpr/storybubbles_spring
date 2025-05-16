package storybubbles.storybubbles_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import storybubbles.storybubbles_spring.model.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Long>{
    
}

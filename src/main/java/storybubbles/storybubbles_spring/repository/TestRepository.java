package storybubbles.storybubbles_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import storybubbles.storybubbles_spring.model.Test;

public interface TestRepository extends JpaRepository<Test, Long> {    
}

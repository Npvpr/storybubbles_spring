package storybubbles.storybubbles_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import storybubbles.storybubbles_spring.model.Story;

public interface StoryRepository extends JpaRepository<Story, Long> {

}

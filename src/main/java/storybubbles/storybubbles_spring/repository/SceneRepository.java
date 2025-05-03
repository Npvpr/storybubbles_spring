package storybubbles.storybubbles_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import storybubbles.storybubbles_spring.model.Scene;

public interface SceneRepository extends JpaRepository<Scene, Long>{
    List<Scene> findAllByStoryId(Long storyId);
}

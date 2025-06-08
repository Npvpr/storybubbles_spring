package storybubbles.storybubbles_spring.service;

import storybubbles.storybubbles_spring.dto.StoryWithScenesResponse;
import storybubbles.storybubbles_spring.model.*;
import storybubbles.storybubbles_spring.repository.SceneRepository;
import storybubbles.storybubbles_spring.repository.StoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Marks this as a Spring-managed service
public class StoryService {

  @Autowired
  private StoryRepository storyRepository;

  @Autowired
  private SceneRepository sceneRepository;

  public StoryWithScenesResponse getStoryWithScenesById(Long storyId) {
    Story story = storyRepository.findById(storyId).orElseThrow();
    List<Scene> scenes = sceneRepository.findAllByStoryId(storyId);

    return new StoryWithScenesResponse(story, scenes);
  }

  public List<Story> getAllStories(){
    return storyRepository.findAll();
  }
}

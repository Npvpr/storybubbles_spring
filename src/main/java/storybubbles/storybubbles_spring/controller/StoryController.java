package storybubbles.storybubbles_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import storybubbles.storybubbles_spring.model.Story;
import storybubbles.storybubbles_spring.service.StoryService;

@RestController
public class StoryController {

  @Autowired // Injects the StoryService
  private StoryService storyService;

  // @GetMapping("/story")
  // public Story getStory() {
  //   return storyService.getDemoStory();
  // }
}
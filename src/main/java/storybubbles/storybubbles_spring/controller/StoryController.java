package storybubbles.storybubbles_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import storybubbles.storybubbles_spring.dto.StoryDto;
import storybubbles.storybubbles_spring.service.StoryService;

@RestController
@RequestMapping("/story")
public class StoryController {

  @Autowired // Injects the StoryService
  private StoryService storyService;

  @GetMapping
  public StoryDto getStory(@RequestParam Long storyId) {
    return storyService.getStory(storyId);
  }
}
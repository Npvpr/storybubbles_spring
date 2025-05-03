package storybubbles.storybubbles_spring.service;

import storybubbles.storybubbles_spring.model.*;

import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service // Marks this as a Spring-managed service
public class StoryService {

  // Hardcode a single story (your app's first story)
  // public Story getDemoStory() {
  //   Story story = new Story();

  //   // Add 4 chapters
  //   for (int chapterId = 1; chapterId <= 4; chapterId++) {
  //     Chapter chapter = new Chapter("chapter-" + chapterId);
      
  //     // Add 4 scenes per chapter
  //     for (int sceneId = 1; sceneId <= 4; sceneId++) {
  //       Scene scene = new Scene("scene-" + chapterId + "-" + sceneId);
        
  //       // Add sample dialogues (narration)
  //       scene.setDialogues(Arrays.asList(
  //         "Once upon a time...",
  //         "And then..."
  //       ));

  //       // Add a question to the scene
  //       Question question = new Question(
  //         "q-" + chapterId + "-" + sceneId,
  //         "What should the character do next?",
  //         Arrays.asList("Choice 1", "Choice 2", "Choice 3", "Choice 4"), // 4 options
  //         0 // Correct answer index (e.g., 0 = first choice)
  //       );
  //       scene.setQuestion(question);
        
  //       chapter.addScene(scene);
  //     }
  //     // story.addChapter(chapter);
  //   }
  //   return story;
  // }
}

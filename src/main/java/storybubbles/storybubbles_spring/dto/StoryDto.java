package storybubbles.storybubbles_spring.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import storybubbles.storybubbles_spring.model.*;

@Getter
@AllArgsConstructor
public class StoryDto {
    private Story story;
    private List<Scene> scenes;
}

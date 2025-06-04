package storybubbles.storybubbles_spring.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoryAnswersRequest {
    private UUID userId;
    private Long storyId;
}

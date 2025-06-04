package storybubbles.storybubbles_spring.dto;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoryAnswersResponse {
    private List<HashMap<String, String>> answersList;
    private int correctCount;
}

package storybubbles.storybubbles_spring.dto;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class UserAllAnswersDTO {
    // this will also allow dynamic number of tests
    private List<List<HashMap<String, String>>> userTests;
    // this way number of stories can be dynamic
    private List<StoryAnswersDTO> userStories;
    private int totalCorrectCount;
}

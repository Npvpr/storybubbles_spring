package storybubbles.storybubbles_spring.dto;

import java.util.HashMap;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import storybubbles.storybubbles_spring.model.User;

@Getter
@AllArgsConstructor
public class UserAllAnswersDTO {
    private User user;
    // this will also allow dynamic number of tests
    private List<List<HashMap<String, String>>> userTests;
    // this way number of stories can be dynamic
    private List<StoryAnswersDTO> userStories;
    private int totalCorrectCount;
}

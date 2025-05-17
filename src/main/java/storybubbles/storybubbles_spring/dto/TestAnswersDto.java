package storybubbles.storybubbles_spring.dto;

import java.util.HashMap;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TestAnswersDto {
    private UUID userId;
    private HashMap<Long, Integer> questionsAnswers;
}

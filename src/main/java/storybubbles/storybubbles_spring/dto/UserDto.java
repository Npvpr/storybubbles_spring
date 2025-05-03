package storybubbles.storybubbles_spring.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Without getter methods, converting from UserDto to ResponseEntity<>(JSON) will cause error
@Getter
@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String username;
    private String profileImage;

}

package storybubbles.storybubbles_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateUserRequest {
    
    @NotBlank(message = "username must not be empty")
    @Size(min = 3, max = 20, message = "username must be between 3 and 20 characters")
    private String username;

    @NotBlank(message = "profileImage URL must not be empty")
    private String profileImage;
}

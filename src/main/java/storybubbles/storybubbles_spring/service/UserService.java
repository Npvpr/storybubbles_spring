package storybubbles.storybubbles_spring.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import storybubbles.storybubbles_spring.dto.CreateUserRequest;
import storybubbles.storybubbles_spring.dto.UserDto;
import storybubbles.storybubbles_spring.model.User;
import storybubbles.storybubbles_spring.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private S3Service s3Service;

    public UserDto createUser(CreateUserRequest request) {
        User savedUser = userRepository.save(new User(request.getUsername(), request.getProfileImage()));
        return new UserDto(savedUser.getId(), savedUser.getUsername(), savedUser.getProfileImage());
    }

    public UserDto getUserDto(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return new UserDto(
            user.getId(),
            user.getUsername(),
            s3Service.generatePublicUrl(user.getProfileImage())
        );
    }

    public User getUserById(UUID userId){
        return userRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
    }
}

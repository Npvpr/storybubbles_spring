package storybubbles.storybubbles_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import storybubbles.storybubbles_spring.dto.CreateUserRequest;
import storybubbles.storybubbles_spring.dto.UserDto;
import storybubbles.storybubbles_spring.service.S3Service;
import storybubbles.storybubbles_spring.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private S3Service s3Service;

    // Get all available profile images
    @GetMapping("/profile-images")
    public List<String> getProfileImages() {
        return s3Service.getAllProfileImageUrls().stream()
            .map(String::new)
            .toList();
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserDto createdUser = userService.createUser(request);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}

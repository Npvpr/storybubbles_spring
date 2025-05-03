package storybubbles.storybubbles_spring.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import storybubbles.storybubbles_spring.model.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    
}

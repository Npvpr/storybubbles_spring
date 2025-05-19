package storybubbles.storybubbles_spring.model;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
// "user" is a reserved keyword in SQL, so without explicit naming like this, it will cause "identifier"/syntax error
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    // this shouldn't return in json
    private String DEFAULT_PROFILE_IMAGE = "1";

    @Id
    @UuidGenerator
    @Setter(value = AccessLevel.NONE)
    private UUID id; // Unique ID (auto-generated, even if username isn't unique)

    @Column(nullable = false, length = 20)
    private String username;

    @Column(name = "profile_image", nullable = false, length = 255)
    private String profileImage; // URL/path to 1 of 9 system-provided images

    public User(String username, String profileImage){
        this.username = username;
        this.profileImage = profileImage;
    }

}
package storybubbles.storybubbles_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import storybubbles.storybubbles_spring.model.User;
import storybubbles.storybubbles_spring.repository.UserRepository;

@SpringBootTest
class StorybubblesSpringApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	void contextLoads() {

	}

	@Test
	public void whenSavingUserWithoutAnId_thenSavingEntityOk() {
		User user = new User();
		User savedUser = userRepository.save(user);
		System.out.println("Saved User ID: " + savedUser.getId());
		assertThat(savedUser.getId()).isNotNull();
	}

}

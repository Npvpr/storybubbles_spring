package storybubbles.storybubbles_spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import storybubbles.storybubbles_spring.model.AnswerRecord;
import java.util.UUID;

public interface AnswerRecordRepository extends JpaRepository<AnswerRecord, Long>{
    Optional<AnswerRecord> findByUserIdAndQuestionId(UUID userId, Long questionId);
}

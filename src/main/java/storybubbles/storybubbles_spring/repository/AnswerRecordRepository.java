package storybubbles.storybubbles_spring.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import storybubbles.storybubbles_spring.model.AnswerRecord;

public interface AnswerRecordRepository extends JpaRepository<AnswerRecord, UUID>{
    
}

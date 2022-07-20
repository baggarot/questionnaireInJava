package questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import questionnaire.model.PollResult;

public interface PollResultRepository extends JpaRepository<PollResult, Integer> {
}

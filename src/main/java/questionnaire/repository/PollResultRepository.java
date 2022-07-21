package questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import questionnaire.model.PollResult;

public interface PollResultRepository extends JpaRepository<PollResult, Integer> {

    @Query(value = "SELECT * FROM POLL_RESULT ORDER BY id DESC LIMIT 1", nativeQuery = true)
    PollResult findLastBy();
}

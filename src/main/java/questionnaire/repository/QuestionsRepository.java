package questionnaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import questionnaire.model.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Integer> {
}

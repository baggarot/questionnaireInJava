package questionnaire.dao;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import questionnaire.model.Questions;
import questionnaire.repository.QuestionsRepository;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class QuestionsRepositoryTest {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Test
    public void shouldReturnCorrectAllQuestionsList() {
        val questions = questionsRepository.findAll();
        assertThat(questions).isNotNull().hasSize(0)
                .allMatch(not(question -> question.getQuestion().isEmpty()))
                .allMatch(not(question -> question.getFirstAnswer().isEmpty()))
                .allMatch(not(question -> question.getSecondAnswer().isEmpty()))
                .allMatch(not(question -> question.getThirdAnswer().isEmpty()))
                .allMatch(not(question -> question.getFourthAnswer().isEmpty()))
                .allMatch(not(question -> question.getCorrectAnswer().isEmpty()));
        questions.forEach(System.out::println);
    }

    @Test
    public void shouldSaveAndLoadCorrectUser() {
        val expectedQuestion = new Questions();
        expectedQuestion.setId(1);
        expectedQuestion.setQuestion("expected question");
        expectedQuestion.setFirstAnswer("expected first answer");
        expectedQuestion.setSecondAnswer("expected second answer");
        expectedQuestion.setThirdAnswer("expected third answer");
        expectedQuestion.setFourthAnswer("expected fourth answer");
        expectedQuestion.setCorrectAnswer("expected correct answer");
        val actualQuestion = questionsRepository.save(expectedQuestion);
        assertThat(actualQuestion).isEqualTo(expectedQuestion);
    }

    @Test
    public void shouldDeleteAllQuestion() {
        val questionCountBefore = questionsRepository.findAll().size();
        questionsRepository.deleteAll();
        val questionCountAfter = questionsRepository.findAll().size();
        assertThat(questionCountBefore).isEqualTo(questionCountAfter);
    }
}
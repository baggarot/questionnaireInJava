package questionnaire.dao;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import questionnaire.model.PollResult;
import questionnaire.repository.PollResultRepository;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PollResultRepositoryTest {

    @Autowired
    private PollResultRepository resultRepository;

    @Test
    public void shouldSaveAndLoadCorrectPollResult() {
        val expectedPollResult = new PollResult();
        expectedPollResult.setDate(new Date());
        expectedPollResult.setResult(5);
        val actualPollResult = resultRepository.save(expectedPollResult);
        assertThat(actualPollResult).isEqualTo(expectedPollResult);
    }
}
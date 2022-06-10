package questionnaire.service;

import questionnaire.model.Questions;

import java.io.IOException;
import java.util.List;

public interface SearchAndSelectionOfQuestions {

    List<Questions> allQuestions();
    void deleteQuestions();
    void saveQuestions(Questions questions) throws IOException;
}

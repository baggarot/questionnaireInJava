package questionnaire.service;

import questionnaire.model.Questions;

import java.io.IOException;
import java.util.List;

public interface SearchAndSelectionOfQuestions {

    List<Questions> allQuestions();
    Questions findById(int questId);
    void deleteQuestions();
    void saveQuestions(int id, Questions questions) throws IOException;
}

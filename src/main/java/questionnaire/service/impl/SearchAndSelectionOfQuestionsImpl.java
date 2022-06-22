package questionnaire.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import questionnaire.model.Questions;
import questionnaire.repository.QuestionsRepository;
import questionnaire.service.SearchAndSelectionOfQuestions;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SearchAndSelectionOfQuestionsImpl implements SearchAndSelectionOfQuestions {

    private final QuestionsRepository questionsRepository;

    @Override
    public List<Questions> allQuestions() {
        return questionsRepository.findAll();
    }

    @Override
    public Questions findById(int questId) {
        Optional<Questions> questionsFromDB = questionsRepository.findById(questId);
        return questionsFromDB.orElse(new Questions());
    }

    @Override
    public void deleteQuestions() {
        questionsRepository.deleteAll();
    }

    @Override
    public void saveQuestions(int id, Questions questions) throws IOException {
        List<List<String>> lines = randomize();
        questions.setId(id);
        questions.setQuestion(lines.get(0).get(0));
        questions.setFirstAnswer(lines.get(0).get(1));
        questions.setSecondAnswer(lines.get(0).get(2));
        questions.setThirdAnswer(lines.get(0).get(3));
        questions.setFourthAnswer(lines.get(0).get(4));
        questions.setCorrectAnswer(lines.get(0).get(5));
        questionsRepository.save(questions);
    }

    private List<List<String>> randomize() throws IOException {
        List<List<String>> questionList = new ArrayList<>();
        RandomAccessFile csvFile = new RandomAccessFile("questions.csv", "r");
        Random random = new Random();
        int value = random.nextInt((int) csvFile.length());
        csvFile.seek(value);
        csvFile.readLine();
        String question = csvFile.readLine();
        String[] array = question.split(";");
        questionList.add(Arrays.asList(array));
        return questionList;
    }
}
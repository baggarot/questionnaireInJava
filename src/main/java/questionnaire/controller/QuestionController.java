package questionnaire.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.model.PollResult;
import questionnaire.model.Questions;
import questionnaire.service.PollResultService;
import questionnaire.service.SearchAndSelectionOfQuestions;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final SearchAndSelectionOfQuestions selectionOfQuestions;
    private final PollResultService pollResultService;
    private int counter = 0;
    private int resultQuestionnaire;

    @RequestMapping("/")
    public String index() {
        return "welcome";
    }

    @RequestMapping(path = "/questionnaire", method = RequestMethod.GET)
    public String questionnaire(Model model) throws IOException {
        if (!selectionOfQuestions.allQuestions().isEmpty()) selectionOfQuestions.deleteQuestions();
        if (callCounter() < 21) {
            selectionOfQuestions.saveQuestions(1, new Questions());
            model.addAttribute("questions", selectionOfQuestions.findById(1));
            return "questionnaire";
        }
        return "redirect:/";
    }

    @RequestMapping(path = "/questionnaire", method = RequestMethod.POST)
    public String handlingQuestions(HttpServletRequest request) {
        if (callCounter() < 21) {
            String answer = request.getParameter("answer");
            if (answer.equals(selectionOfQuestions.findById(1).getCorrectAnswer()))
                resultQuestionnaire += 1;
            return "questionnaire";
        }
        PollResult pollResult = new PollResult();
        pollResult.setDate(new Date());
        pollResult.setResult(resultQuestionnaire);
        pollResultService.saveResult(pollResult);
        return "redirect:/";
    }

    private int callCounter() {
        return counter++;
    }
}

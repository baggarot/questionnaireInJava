package questionnaire.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import questionnaire.model.Questions;
import questionnaire.service.SearchAndSelectionOfQuestions;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final SearchAndSelectionOfQuestions selectionOfQuestions;

    @RequestMapping("/")
    public String index() {
        return "welcome";
    }

    @RequestMapping(path = "/questionnaire", method = RequestMethod.GET)
    public String questionnaire(Model model) throws IOException {
        if (!selectionOfQuestions.allQuestions().isEmpty()) selectionOfQuestions.deleteQuestions();
        for (int i = 1; i <= 10; i++) {
            selectionOfQuestions.saveQuestions(i, new Questions());
            model.addAttribute("questions" + i, selectionOfQuestions.findById(i));
        }
        return "questionnaire";
    }

    @RequestMapping(path = "/questionnaire", method = RequestMethod.POST)
    public String newQuestions(@ModelAttribute("questionForm") @Valid Questions questionForm,
                               Model model) {
        return "redirect:/";
    }
}

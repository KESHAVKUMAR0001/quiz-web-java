package com.quiz.app.controller;

import com.quiz.app.model.QuizEvaluationResult;
import com.quiz.app.model.QuizSubmissionForm;
import com.quiz.app.model.Result;
import com.quiz.app.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/quiz")
    public String startQuiz(@RequestParam(defaultValue = "") String username,
                            @RequestParam(defaultValue = "5") int questionCount,
                            Model model,
                            RedirectAttributes redirectAttributes) {
        if (username.trim().isEmpty()) {
            redirectAttributes.addFlashAttribute("warning", "Please enter your name to start the quiz.");
            return "redirect:/";
        }

        // Limit question count to safe bounds (3 to 15)
        int safeCount = Math.max(3, Math.min(questionCount, 15));
        QuizSubmissionForm quizForm = quizService.createQuizForm(username.trim(), safeCount);

        model.addAttribute("quizForm", quizForm);
        model.addAttribute("totalQuestions", quizForm.getQuestions().size());

        return "quiz";
    }

    @PostMapping("/submit")
    public String submitQuiz(@ModelAttribute QuizSubmissionForm quizForm, Model model) {
        if (quizForm.getQuestions() == null || quizForm.getQuestions().isEmpty()) {
            return "redirect:/";
        }

        QuizEvaluationResult evaluation = quizService.evaluateSubmission(quizForm);

        model.addAttribute("result", evaluation.getResult());
        model.addAttribute("reviews", evaluation.getReviews());

        return "result";
    }

    @GetMapping({"/scoreboard", "/score"})
    public String scoreboard(Model model) {
        List<Result> topScores = quizService.getLeaderboard();
        model.addAttribute("scores", topScores);
        return "scoreboard";
    }
}

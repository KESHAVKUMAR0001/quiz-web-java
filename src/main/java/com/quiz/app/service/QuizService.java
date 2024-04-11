package com.quiz.app.service;

import com.quiz.app.model.*;
import com.quiz.app.repository.QuestionRepository;
import com.quiz.app.repository.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final QuestionRepository questionRepository;
    private final ResultRepository resultRepository;

    public QuizService(QuestionRepository questionRepository, ResultRepository resultRepository) {
        this.questionRepository = questionRepository;
        this.resultRepository = resultRepository;
    }

    /**
     * Prepares a randomized quiz form containing questionCount questions.
     * Crucially, the correct answers are NOT sent to the client.
     */
    public QuizSubmissionForm createQuizForm(String username, int questionCount) {
        List<Question> allQuestions = questionRepository.findAll();
        Collections.shuffle(allQuestions);

        int count = Math.min(questionCount, allQuestions.size());
        List<QuestionDto> selected = allQuestions.stream()
                .limit(count)
                .map(QuestionDto::fromEntity)
                .collect(Collectors.toList());

        return new QuizSubmissionForm(username, selected);
    }

    /**
     * Evaluates user submissions by comparing user choices against verified database answers.
     * Saves the result and produces a question-by-question review.
     */
    public QuizEvaluationResult evaluateSubmission(QuizSubmissionForm form) {
        int totalCorrect = 0;
        List<QuestionReviewDto> reviews = new ArrayList<>();

        if (form.getQuestions() != null) {
            for (QuestionDto submittedQ : form.getQuestions()) {
                Optional<Question> originalOpt = questionRepository.findById(submittedQ.getId());
                if (originalOpt.isPresent()) {
                    Question original = originalOpt.get();
                    int chosen = submittedQ.getSelectedOption();
                    boolean isCorrect = (chosen == original.getCorrectOption());

                    if (isCorrect) {
                        totalCorrect++;
                    }

                    String chosenText = getOptionText(original, chosen);
                    String correctText = getOptionText(original, original.getCorrectOption());

                    reviews.add(new QuestionReviewDto(
                            original.getTitle(),
                            chosenText,
                            correctText,
                            isCorrect
                    ));
                }
            }
        }

        int totalQuestions = form.getQuestions() != null ? form.getQuestions().size() : 0;
        String username = (form.getUsername() != null && !form.getUsername().trim().isEmpty())
                ? form.getUsername().trim()
                : "Anonymous";

        Result result = new Result(username, totalCorrect, totalQuestions);
        Result savedResult = resultRepository.save(result);

        return new QuizEvaluationResult(savedResult, reviews);
    }

    public List<Result> getLeaderboard() {
        return resultRepository.findTop15ByOrderByTotalCorrectDescPercentageDescSubmittedAtDesc();
    }

    private String getOptionText(Question q, int optionNum) {
        return switch (optionNum) {
            case 1 -> "A) " + q.getOptionA();
            case 2 -> "B) " + q.getOptionB();
            case 3 -> "C) " + q.getOptionC();
            case 4 -> "D) " + q.getOptionD();
            default -> "Not Answered";
        };
    }
}

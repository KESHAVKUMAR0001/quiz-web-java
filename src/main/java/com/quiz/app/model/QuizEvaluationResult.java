package com.quiz.app.model;

import java.util.List;

public class QuizEvaluationResult {

    private Result result;
    private List<QuestionReviewDto> reviews;

    public QuizEvaluationResult() {
    }

    public QuizEvaluationResult(Result result, List<QuestionReviewDto> reviews) {
        this.result = result;
        this.reviews = reviews;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public List<QuestionReviewDto> getReviews() {
        return reviews;
    }

    public void setReviews(List<QuestionReviewDto> reviews) {
        this.reviews = reviews;
    }
}

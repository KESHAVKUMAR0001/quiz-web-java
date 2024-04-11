package com.quiz.app.model;

public class QuestionReviewDto {

    private String questionTitle;
    private String userChoiceText;
    private String correctChoiceText;
    private boolean correct;

    public QuestionReviewDto() {
    }

    public QuestionReviewDto(String questionTitle, String userChoiceText, String correctChoiceText, boolean correct) {
        this.questionTitle = questionTitle;
        this.userChoiceText = userChoiceText;
        this.correctChoiceText = correctChoiceText;
        this.correct = correct;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getUserChoiceText() {
        return userChoiceText;
    }

    public void setUserChoiceText(String userChoiceText) {
        this.userChoiceText = userChoiceText;
    }

    public String getCorrectChoiceText() {
        return correctChoiceText;
    }

    public void setCorrectChoiceText(String correctChoiceText) {
        this.correctChoiceText = correctChoiceText;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}

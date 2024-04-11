package com.quiz.app.model;

import java.util.ArrayList;
import java.util.List;

public class QuizSubmissionForm {

    private String username;
    private List<QuestionDto> questions = new ArrayList<>();

    public QuizSubmissionForm() {
    }

    public QuizSubmissionForm(String username, List<QuestionDto> questions) {
        this.username = username;
        this.questions = questions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}

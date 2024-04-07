package com.quiz.app.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "total_correct", nullable = false)
    private int totalCorrect;

    @Column(name = "total_questions", nullable = false)
    private int totalQuestions;

    @Column(name = "percentage", nullable = false)
    private double percentage;

    @Column(name = "submitted_at", nullable = false)
    private LocalDateTime submittedAt;

    public Result() {
        this.submittedAt = LocalDateTime.now();
    }

    public Result(String username, int totalCorrect, int totalQuestions) {
        this.username = username;
        this.totalCorrect = totalCorrect;
        this.totalQuestions = totalQuestions;
        this.percentage = totalQuestions > 0 ? ((double) totalCorrect / totalQuestions) * 100.0 : 0.0;
        this.submittedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getTotalCorrect() {
        return totalCorrect;
    }

    public void setTotalCorrect(int totalCorrect) {
        this.totalCorrect = totalCorrect;
        if (this.totalQuestions > 0) {
            this.percentage = ((double) totalCorrect / this.totalQuestions) * 100.0;
        }
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        if (this.totalQuestions > 0) {
            this.percentage = ((double) this.totalCorrect / totalQuestions) * 100.0;
        }
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getFormattedDate() {
        if (submittedAt == null) return "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
        return submittedAt.format(formatter);
    }
}

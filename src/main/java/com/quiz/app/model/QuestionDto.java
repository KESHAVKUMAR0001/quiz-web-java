package com.quiz.app.model;

/**
 * Data Transfer Object sent to the client.
 * Note: Does NOT include the correct answer to prevent cheating via browser inspection.
 */
public class QuestionDto {

    private Long id;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int selectedOption; // Bound during submission (1, 2, 3, 4)

    public QuestionDto() {
    }

    public QuestionDto(Long id, String title, String optionA, String optionB, String optionC, String optionD) {
        this.id = id;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.selectedOption = -1;
    }

    public static QuestionDto fromEntity(Question q) {
        return new QuestionDto(
            q.getId(),
            q.getTitle(),
            q.getOptionA(),
            q.getOptionB(),
            q.getOptionC(),
            q.getOptionD()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public int getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(int selectedOption) {
        this.selectedOption = selectedOption;
    }
}

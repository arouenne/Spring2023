package sample.data.jpa.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "question_choice")
public class QuestionChoice {
    private Long id;

    private String title;

    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "id")
    private Question question;

    public QuestionChoice(String title, boolean correct) {
        this.title = title;
        this.correct = correct;
    }

    public QuestionChoice() {

    }

    @Id
    @GeneratedValue()
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}

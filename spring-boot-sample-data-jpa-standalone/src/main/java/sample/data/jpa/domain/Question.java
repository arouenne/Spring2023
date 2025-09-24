package sample.data.jpa.domain;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Question extends Activity {
    private String title;

    private List<QuestionChoice> choices;

    private Long id;

    public Question(String title, List<QuestionChoice> choices) {
        this.title = title;
        this.choices = choices;
    }

    public Question() {

    }

    @NotNull
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    public List<QuestionChoice> getChoices() {
        return choices;
    }

    public void setChoices(List<QuestionChoice> choices) {
        this.choices = choices;
    }
}

package sample.data.jpa.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "kahoot")
public class Kahoot {

    private Long id;

    private List<Activity> activities;

    private List<User> users;

    private int code;

    public Kahoot(int code) {
        this.code = code;
    }

    public Kahoot(long id) {
        this.id = id;
    }

    public Kahoot() {

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActivity(List<Activity> activities) {
        this.activities = activities;
    }

    @NotNull
    @OneToMany()
    @JoinColumn(name = "kahoot_id")
    public List<Activity> getActivity() {
        return activities;
    }

    @NotNull
    @OneToMany
    @JoinColumn(name = "kahoot_id")
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @NotNull
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

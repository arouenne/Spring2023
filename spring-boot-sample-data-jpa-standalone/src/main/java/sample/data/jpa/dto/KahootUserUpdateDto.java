package sample.data.jpa.dto;

import sample.data.jpa.domain.User;

/**
 * Dto class to add a user to the given Kahoot.
 */
public class KahootUserUpdateDto {

    private Long id;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

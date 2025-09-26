package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import sample.data.jpa.domain.User;

import java.util.List;

@Transactional
public interface UserDao extends JpaRepository<User, Long> {

    /**
     * This method will find a User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name = 'Hugo' OR u.name = 'Arwen'")
    List<User> findAuthors();
}
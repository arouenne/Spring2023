package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import sample.data.jpa.domain.Kahoot;
import sample.data.jpa.domain.Question;

@Transactional
public interface QuestionDao extends JpaRepository<Question, Long> {

}
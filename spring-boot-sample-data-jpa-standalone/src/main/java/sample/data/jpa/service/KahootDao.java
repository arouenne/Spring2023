package sample.data.jpa.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import sample.data.jpa.domain.Kahoot;

@Transactional
public interface KahootDao extends JpaRepository<Kahoot, Long> {

    // TODO
}
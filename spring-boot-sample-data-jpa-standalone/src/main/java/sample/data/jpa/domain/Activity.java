package sample.data.jpa.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "activity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Activity implements Serializable {

    private Long id;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

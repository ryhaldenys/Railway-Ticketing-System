package ua.nulp.kn303.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "email")
@Entity
@Table(name = "user",schema = "lab3-4")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @NaturalId
    @Column(nullable = false)
    private String email;
}

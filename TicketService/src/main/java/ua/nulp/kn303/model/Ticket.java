package ua.nulp.kn303.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = "ticketNumber")
@NoArgsConstructor
@Entity
@Table(schema = "lab3-4")
public class Ticket {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String ticketNumber;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Long trainId;

    @Column(nullable = false)
    private Long trainCarId;

    @Column(nullable = false)
    private Long userId;

}

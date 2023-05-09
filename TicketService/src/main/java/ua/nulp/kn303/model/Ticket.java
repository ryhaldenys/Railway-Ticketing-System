package ua.nulp.kn303.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static ua.nulp.kn303.model.Ticket.PaymentStatus.*;
import static ua.nulp.kn303.model.Ticket.TicketStatus.*;

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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus = UNPAID;

    public enum PaymentStatus {
        UNPAID,PAID
    }

    @Column(nullable = false, name = "ticket_status")
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus = ACTIVE;

    public enum TicketStatus {
        ACTIVE,EXPIRED,CANCELED
    }

    @Column(nullable = false)
    private Long userId;

}

package ua.nulp.kn303.dto;

import ua.nulp.kn303.model.Ticket;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record TicketDto(Long id, String ticketNumber, Ticket.PaymentStatus paymentStatus, Ticket.TicketStatus ticketStatus, String userName, LocalDate data, String trainName,
                        String trainType, String arrivalStation, String departureStation, LocalTime arrivalTime, LocalTime departureTime,
                        String trainCarNumber, String type, BigDecimal price) {
}

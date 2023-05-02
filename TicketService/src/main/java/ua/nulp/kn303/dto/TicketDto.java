package ua.nulp.kn303.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public record TicketDto(String ticketNumber, String userName, LocalDate data, String trainName,
                        String trainType, String arrivalStation, String departureStation, LocalTime arrivalTime, LocalTime departureTime,
                        String trainCarNumber, String type, BigDecimal price) {
}

package ua.nulp.kn303.dto;

import java.time.LocalDate;

public record RequestTicketDto(Long userId, Long trainId, Long carId, LocalDate date) {
}

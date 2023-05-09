package ua.hulp.kn303.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record RequestPaymentDto(Long ticketId, String username, String cardNumber, Integer sv, LocalDate cardDate, BigDecimal price) {
}

package ua.hulp.kn303.dto;

import java.math.BigDecimal;

public record ResponsePaymentDto(String customer, String company, BigDecimal price) {
}

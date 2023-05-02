package ua.nulp.kn303.dto;

import java.math.BigDecimal;

public record TrainCarDto(String trainCarNumber, String type, BigDecimal price, Long trainId) {
}

package ua.nulp.kn303.dto;

import ua.nulp.kn303.model.TrainCar;

import java.math.BigDecimal;

public record TrainCarDto(String trainCarNumber, TrainCar.TrainCarType type, BigDecimal price, Long trainId) {
}

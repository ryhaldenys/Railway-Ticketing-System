package ua.nulp.kn303.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalTime;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrainDto {
    private String trainName;
    private String trainType;
    private String arrivalStation;
    private String departureStation;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private String dayOfWeek;
}

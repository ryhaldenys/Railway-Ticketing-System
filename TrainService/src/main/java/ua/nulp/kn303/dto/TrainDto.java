package ua.nulp.kn303.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ua.nulp.kn303.model.Train;


import java.time.LocalTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TrainDto {
    private Long trainId;
    private String trainName;
    private Train.TrainType trainType;
    private String arrivalStation;
    private String departureStation;
    private LocalTime arrivalTime;
    private LocalTime departureTime;
    private String dayOfWeek;
    private Long amountOFTrainCars;
}

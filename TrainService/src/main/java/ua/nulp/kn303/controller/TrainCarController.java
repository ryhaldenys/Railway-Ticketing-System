package ua.nulp.kn303.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.nulp.kn303.dto.TrainCarDto;
import ua.nulp.kn303.service.TrainCarService;

import java.util.List;

@RestController
@RequestMapping("trains/{id}/train-cars")
@RequiredArgsConstructor
public class TrainCarController {
    private final TrainCarService trainCarService;

    @GetMapping
    public List<TrainCarDto> getTrainCarsByTrainId(@PathVariable Long id){
        return trainCarService.getAllTrainCarsByTrainId(id);
    }

    @GetMapping("/{car_id}")
    public TrainCarDto getTrainCarByTrainIdAndId(@PathVariable Long id,@PathVariable("car_id")Long carId){
        return trainCarService.getTrainCarByTrainIdAndId(id,carId);
    }


}

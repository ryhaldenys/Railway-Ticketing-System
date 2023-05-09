package ua.nulp.kn303.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.nulp.kn303.dto.TrainDto;
import ua.nulp.kn303.service.TrainService;

import java.util.List;

@RestController
@RequestMapping("/trains")
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;

    @GetMapping()
    public List<TrainDto> getAllTrains(@RequestParam(value = "arrStation",defaultValue = "") String arrStation,
                                       @RequestParam(value = "depStation",defaultValue = "") String depStation){

        return trainService.getAllTrainCars(arrStation, depStation);
    }

    @GetMapping("/{id}")
    public TrainDto getTrainById(@PathVariable Long id){
        return trainService.getTrainById(id);
    }

}

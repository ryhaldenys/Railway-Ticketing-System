package ua.nulp.kn303.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nulp.kn303.dto.TrainDto;
import ua.nulp.kn303.exception.TrainNotFoundException;
import ua.nulp.kn303.repository.TrainRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TrainService {
    private final TrainRepository trainRepository;

    public List<TrainDto> getAllTrainCars(String arrStation,String depStation){
        List<TrainDto> trains;
        var isArrStation = !arrStation.isEmpty();
        var isDepStation = !depStation.isEmpty();

        if (isArrStation && isDepStation)
            trains = trainRepository.findAllByArrivalAndDepartureStations(arrStation, depStation);
        else if(isArrStation)
            trains = trainRepository.findAllByArrivalStation(arrStation);
        else if (isDepStation) {
            trains = trainRepository.findAllByDepartureStation(depStation);
        }else
            throw new TrainNotFoundException("Cannot find any trains");

        return trains;
    }
}

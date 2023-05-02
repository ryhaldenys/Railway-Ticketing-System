package ua.nulp.kn303.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nulp.kn303.dto.TrainCarDto;
import ua.nulp.kn303.repository.TrainCarRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TrainCarService {
    private final TrainCarRepository trainCarRepository;

    public List<TrainCarDto> getAllTrainCarsByTrainId(Long trainId){
        return trainCarRepository.findAllTrainCarsByTrainId(trainId);
    }

    public TrainCarDto getTrainCarByTrainIdAndId(Long trainId,Long carId) {
        return trainCarRepository.findTrainCarByTrainIdAndId(trainId,carId).orElseThrow();
    }
}

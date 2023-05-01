package ua.nulp.kn303.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.nulp.kn303.dto.TrainCarDto;
import ua.nulp.kn303.model.TrainCar;

import java.util.List;

public interface TrainCarRepository extends JpaRepository<TrainCar,Long> {

    @Query("select new ua.nulp.kn303.dto.TrainCarDto(tc.trainCarNumber, tc.type,tc.price,t.id) " +
            "from TrainCar tc join tc.train t " +
            "where t.id =?1")
    List<TrainCarDto> findAllTrainCarsByTrainId(Long trainId);
}

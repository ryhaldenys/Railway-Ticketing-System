package ua.nulp.kn303.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.nulp.kn303.dto.TrainDto;
import ua.nulp.kn303.model.Train;

import java.util.List;
import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train,Long> {
    @Query("select new ua.nulp.kn303.dto.TrainDto(t.id,t.name,t.type,ts.arrivalStation,ts.departureStation, " +
            "ts.arrivalTime,ts.departureTime,ts.dayOfWeek, count(distinct tc)) from Train t " +
            "join t.trainSchedule ts left join t.trainCars tc " +
            "where ts.arrivalStation =:arrStation " +
            "group by t,ts")
    List<TrainDto> findAllByArrivalStation(@Param("arrStation") String arrivalStation);

    @Query("select new ua.nulp.kn303.dto.TrainDto(t.id,t.name,t.type,ts.arrivalStation,ts.departureStation, " +
            "ts.arrivalTime,ts.departureTime,ts.dayOfWeek, count(distinct tc)) from Train t " +
            "join t.trainSchedule ts left join t.trainCars tc " +
            "where ts.departureStation =:depStation " +
            "group by t,ts")
    List<TrainDto> findAllByDepartureStation(@Param("depStation") String departureStation);

    @Query("select new ua.nulp.kn303.dto.TrainDto(t.id,t.name,t.type,ts.arrivalStation,ts.departureStation, " +
            "ts.arrivalTime,ts.departureTime,ts.dayOfWeek, count(distinct tc)) from Train t " +
            "join t.trainSchedule ts left join t.trainCars tc " +
            "where ts.departureStation =:depStation and ts.arrivalStation =:arrStation " +
            "group by t,ts")
    List<TrainDto> findAllByArrivalAndDepartureStations(@Param("depStation") String depStation,
                                                        @Param("arrStation") String arrStation);

    @Query("select new ua.nulp.kn303.dto.TrainDto(t.id,t.name,t.type,ts.arrivalStation,ts.departureStation, " +
            "ts.arrivalTime,ts.departureTime,ts.dayOfWeek, count(distinct tc)) from Train t " +
            "join t.trainSchedule ts left join t.trainCars tc " +
            "where t.id =?1 group by t,ts")
    Optional<TrainDto> findTrainById(Long id);
}

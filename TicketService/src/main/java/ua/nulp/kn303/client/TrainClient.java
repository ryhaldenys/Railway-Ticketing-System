package ua.nulp.kn303.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.nulp.kn303.dto.TrainCarDto;
import ua.nulp.kn303.dto.TrainDto;

@FeignClient(name = "trains")
public interface TrainClient {
    @GetMapping("/trains/{id}")
    TrainDto getTrainById(@PathVariable Long id);

    @GetMapping("/trains/{id}/train-cars/{car_id}")
    TrainCarDto getTrainCarByTrainIdAndId(@PathVariable Long id,@PathVariable("car_id") Long carId);
}

package ua.nulp.kn303.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nulp.kn303.client.TrainClient;
import ua.nulp.kn303.client.UserClient;
import ua.nulp.kn303.dto.*;
import ua.nulp.kn303.exception.IncorrectDateOfTrainSchedule;
import ua.nulp.kn303.model.Ticket;
import ua.nulp.kn303.repository.TicketRepository;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
    private final UserClient userClient;
    private final TrainClient trainClient;

    @Transactional
    public void createTicket(RequestTicketDto ticketRequest){
        var ticket = createTicketInstance(ticketRequest);
        var train = getTrain(ticketRequest.trainId());
        checkDateISCorrect(ticketRequest,train);
        ticketRepository.save(ticket);
    }

    private Ticket createTicketInstance(RequestTicketDto ticketRequest){
        var ticket = new Ticket();
        ticket.setTrainId(ticketRequest.trainId());
        ticket.setUserId(ticketRequest.userId());
        ticket.setTicketNumber(UUID.randomUUID().toString());
        ticket.setDate(ticketRequest.date());
        ticket.setTrainCarId(ticketRequest.carId());

        return ticket;
    }
    private TrainDto getTrain(Long trainId){
        return trainClient.getTrainById(trainId);
    }

    private void checkDateISCorrect(RequestTicketDto ticketRequest, TrainDto train) {
        var date = ticketRequest.date();
        var days = train.getDayOfWeek().split(",");
        var currentIntDay = date.getDayOfWeek().getValue();
        System.out.println("Current day: "+currentIntDay);
        System.out.println("Days:" + Arrays.toString(days));
        var currentDay = DayOfWeek.of(currentIntDay).name();
        System.out.println("Current day: "+currentDay);

        check(days,currentDay);
    }

    private void check(String[] days, String currentDay){
        for (var day: days) {
            if (currentDay.equals(day))
                return;
        }
        throw new IncorrectDateOfTrainSchedule("Date is incorrect");
    }



    public TicketDto getTicketById(Long id) {
        var ticket = getTicket(id);
        return createTicketDto(ticket);
    }

    private TicketDto createTicketDto(Ticket ticket){
        var user = userClient.getUserById(ticket.getUserId());
        var train = trainClient.getTrainById(ticket.getTrainId());
        var trainCar = trainClient.getTrainCarByTrainIdAndId(ticket.getTrainId(), ticket.getTrainCarId());

        return createInstanceOfTicketDto(ticket,user,train,trainCar);
    }

    private Ticket getTicket(Long id) {
        return ticketRepository.findById(id).orElseThrow();
    }

    private TicketDto createInstanceOfTicketDto(Ticket ticket, UserDto user, TrainDto train, TrainCarDto trainCar) {
        return new TicketDto(ticket.getTicketNumber(), user.username(), ticket.getDate(),
                train.getTrainName(), train.getTrainType(), train.getArrivalStation(),
                train.getDepartureStation(),train.getArrivalTime(),train.getDepartureTime(),
                trainCar.trainCarNumber(), trainCar.type(), trainCar.price());
    }

    public List<TicketDto> getAllUserTicketsByUserId(Long userId) {
        var tickets = ticketRepository.findAllByUserId(userId);
         return tickets.stream()
                .map(this::mapToTicketDto)
                .toList();
    }
    public TicketDto mapToTicketDto(Ticket ticket){
        return createTicketDto(ticket);
    }
}




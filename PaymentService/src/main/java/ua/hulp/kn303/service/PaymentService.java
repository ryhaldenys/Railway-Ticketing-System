package ua.hulp.kn303.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ua.hulp.kn303.client.TicketClient;
import ua.hulp.kn303.dto.RequestPaymentDto;
import ua.hulp.kn303.dto.ResponsePaymentDto;
import ua.hulp.kn303.exception.ExpiredCardException;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PaymentService {
    @Value("${company.name}")
    private String companyName;
    private final TicketClient ticketClient;

    public ResponsePaymentDto pay(RequestPaymentDto request){
        checkCardIsExpired(request.cardDate());
        setPaidStatus(request.ticketId());
        return new ResponsePaymentDto(request.username(),companyName, request.price());
    }

    private void checkCardIsExpired(LocalDate cardDate) {
        if(cardDate.isBefore(LocalDate.now()))
            throw new ExpiredCardException("User cars is expired");
    }
    private void setPaidStatus(Long ticketId){
        ticketClient.setPaidStatus(ticketId);
    }
}

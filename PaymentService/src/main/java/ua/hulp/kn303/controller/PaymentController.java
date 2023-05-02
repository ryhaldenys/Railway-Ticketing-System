package ua.hulp.kn303.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ua.hulp.kn303.dto.RequestPaymentDto;
import ua.hulp.kn303.dto.ResponsePaymentDto;
import ua.hulp.kn303.service.PaymentService;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping
    @ResponseStatus(CREATED)
    public ResponsePaymentDto pay(@RequestBody RequestPaymentDto request){
        return paymentService.pay(request);
    }

}

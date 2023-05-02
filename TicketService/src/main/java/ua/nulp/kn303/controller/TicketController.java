package ua.nulp.kn303.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import ua.nulp.kn303.dto.RequestTicketDto;
import ua.nulp.kn303.dto.TicketDto;

import ua.nulp.kn303.service.TicketService;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createTicket(@RequestBody RequestTicketDto ticket){
        ticketService.createTicket(ticket);
    }

    @PutMapping("/{id}")
    public void setPaidStatus(@PathVariable Long id){
        ticketService.setPaidStatus(id);
    }


    @GetMapping("/{id}")
    public TicketDto getTicketById(@PathVariable Long id){
        return  ticketService.getTicketById(id);
    }

    @GetMapping
    public List<TicketDto> getAllUserTicketsByUserId(@RequestParam("user_id")Long userId){
        return ticketService.getAllUserTicketsByUserId(userId);
    }
}

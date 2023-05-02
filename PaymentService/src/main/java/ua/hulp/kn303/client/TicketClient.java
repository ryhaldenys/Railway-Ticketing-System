package ua.hulp.kn303.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "tickets")
public interface TicketClient {
    @PutMapping("/tickets/{id}")
    void setPaidStatus(@PathVariable Long id);
}

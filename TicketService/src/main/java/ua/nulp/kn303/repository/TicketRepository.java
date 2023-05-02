package ua.nulp.kn303.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.nulp.kn303.model.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {

    List<Ticket> findAllByUserId(Long userId);
}

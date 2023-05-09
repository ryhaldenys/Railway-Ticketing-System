package ua.nulp.kn303.exception;

public class InvalidTicketStatus extends RuntimeException {
    public InvalidTicketStatus(String message) {
        super(message);
    }
}

package ua.nulp.kn303.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestSettings {
    private LocalDate date;
    private Long trainId;
    private Long trainCarId;
    private Long userId;
}

package ua.nulp.kn303.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "train_schedule",schema = "lab3-4",indexes =
    @Index(name = "train_schedule_train_idx",columnList = "train_id")
)
public class TrainSchedule {
    @Id
    private Long id;

    @Column(name = "arrival_station",nullable = false)
    private String arrivalStation;

    @Column(name = "departure_station",nullable = false)
    private String departureStation;

    @Column(name = "arrival_time",nullable = false)
    private LocalTime arrivalTime;

    @Column(name = "departure_time",nullable = false)
    private LocalTime departureTime;

    @Column(name = "day_of_week",nullable = false)
    private String dayOfWeek;

    @MapsId
    @OneToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id",nullable = false)
    private Train train;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || id == null) return false;

        TrainSchedule that = (TrainSchedule) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


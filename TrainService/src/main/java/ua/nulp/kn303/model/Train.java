package ua.nulp.kn303.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode(of = "trainNumber")
@Table(name = "train",schema = "lab3-4")
public class Train {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false,name = "train_number",unique = true)
    private Integer trainNumber;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TrainType type;

    public enum TrainType{
        HIGH_SPEED, EXPRESS, LONG_DISTANCE, REGIONAL, CITY
    }

    @OneToOne(mappedBy = "train",orphanRemoval = true,cascade = CascadeType.ALL)
    private TrainSchedule trainSchedule;

    @OneToMany(mappedBy = "train",cascade = CascadeType.ALL)
    @Setter(AccessLevel.PRIVATE)
    private List<TrainCar> trainCars = new ArrayList<>();

}

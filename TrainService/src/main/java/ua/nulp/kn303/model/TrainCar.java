package ua.nulp.kn303.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "train_car",schema = "lab3-4",indexes =
    @Index(name = "train_car_train_idx",columnList = "train_id")
)
public class TrainCar {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,name = "tarin_car_number",unique = true)
    private String trainCarNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TrainCarType type;

    public enum TrainCarType{
        COUPE, PLATSCART, GENERAL, RESTAURANT, BAGGAGE, BUSINESS_CLASS
    }

    @Column(name = "passengers_capacity",nullable = false)
    private Integer passengersCapacity;

    @Column(name = "occupied_passengers_spaces",nullable = false)
    @Check(constraints = "occupied_passengers_spaces <= passengers_capacity")
    private Integer occupiedPassengersSpaces;

    @Column(name = "baggage_capacity",nullable = false)
    private Integer baggageCapacity;

    @Column(name = "occupied_luggage_spaces",nullable = false)
    @Check(constraints = "occupied_luggage_spaces <= baggage_capacity")
    private Integer occupiedLuggageSpaces;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id",nullable = false)
    private Train train;

}

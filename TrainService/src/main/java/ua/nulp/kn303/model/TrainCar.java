package ua.nulp.kn303.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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
        COUPE, PLATSCART, GENERAL, BUSINESS_CLASS
    }

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "passengers_capacity",nullable = false)
    private Integer passengersCapacity;

    @Column(name = "baggage_capacity",nullable = false)
    private Integer baggageCapacity;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id",nullable = false)
    private Train train;

}

package com.learning.example.practice.springpracticesession3.Entity.MappingRelations.onetomany;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehicle")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicleId",nullable = false)
    private Integer id;

    @Column(name = "vehicleName",nullable = false)
    private String name;

    @Column(name = "numberOfVehicle",nullable = false)
    private Integer noOfVehicle;

    @Column(name = "vehicleNumber",nullable = false)
    private Long vehicleNumber;

    @Column(name = "vehicleRegistrationDate",nullable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "personId",referencedColumnName = "personId")
    private PersonEntity personEntities;
}
